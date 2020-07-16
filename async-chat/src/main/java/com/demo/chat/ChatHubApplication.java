package com.demo.chat;

import com.demo.chat.app.*;
import com.demo.chat.model.SportEvent;
import com.demo.chat.model.SportExecution;
import com.demo.chat.protobuf.Event;
import com.demo.chat.protobuf.Execution;
import com.demo.chat.repository.ChatRepository;
import com.demo.chat.repository.EventRepository;
import com.demo.chat.repository.ExecutionRepository;
import com.google.protobuf.InvalidProtocolBufferException;
import io.nats.client.Connection;
import io.nats.client.Dispatcher;
import io.nats.client.Nats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.reactive.HandlerMapping;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import org.springframework.web.reactive.handler.SimpleUrlHandlerMapping;
import org.springframework.web.reactive.socket.server.support.WebSocketHandlerAdapter;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.UnicastProcessor;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

@SpringBootApplication
@EnableScheduling
public class ChatHubApplication {

    private static final Logger logger = LoggerFactory.getLogger(ChatHubApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ChatHubApplication.class, args);
    }

    @Bean
    public UnicastProcessor<ChatEvent> eventPublisher() {
        return UnicastProcessor.create();
    }

    @Bean
    public Flux<ChatEvent> events(UnicastProcessor<ChatEvent> eventPublisher) {
        return eventPublisher
                .replay(25)
                .autoConnect();
    }

    @Bean
    public RouterFunction<ServerResponse> routes() {
        return RouterFunctions.route(
                GET("/"),
                request -> ServerResponse.ok().body(BodyInserters.fromResource(new ClassPathResource("public/index.html")))
        );
    }

    @Bean
    public HandlerMapping webSocketMapping(UnicastProcessor<ChatEvent> eventPublisher, Flux<ChatEvent> events) {
        Map<String, Object> map = new HashMap<>();
        map.put("/websocket/chat", new ChatHubSocketHandler(eventPublisher, events));
        SimpleUrlHandlerMapping simpleUrlHandlerMapping = new SimpleUrlHandlerMapping();
        simpleUrlHandlerMapping.setUrlMap(map);

        //Without the order things break :-/
        simpleUrlHandlerMapping.setOrder(10);
        return simpleUrlHandlerMapping;
    }

    @Bean
    public WebSocketHandlerAdapter handlerAdapter() {
        return new WebSocketHandlerAdapter();
    }

    @Bean
    public UserStats userStats(Flux<ChatEvent> events,
                               UnicastProcessor<ChatEvent> eventPublisher,
                               ChatRepository chatRepository) {

        return new UserStats(events, eventPublisher, chatRepository);
    }

    @Bean
    public Connection natsConnection() throws IOException, InterruptedException {
        try {
            return Nats.connect("nats://192.168.248.4:4222");
        } catch (IOException | InterruptedException ex) {
            return null;
        }
    }

    @Bean
    ApplicationRunner init(UnicastProcessor<ChatEvent> eventPublisher, Connection natsConnection,
                           EventRepository eventRepository, ExecutionRepository executionRepository,
                           ChatRepository chatRepository) {
        return args -> {
            FluxSink<ChatEvent> chatEventFluxSink = eventPublisher.sink();
            // for testing, clear all collections
            eventRepository.deleteAll().subscribe();
            executionRepository.deleteAll().subscribe();
            chatRepository.deleteAll().subscribe();

            // get Nats connection and start message dispatcher
            if (natsConnection == null) {
                logger.error("Nats Broker connection not made. Please correct and restart app...");
                return;
            }
            Dispatcher d = natsConnection.createDispatcher((msg) -> {
                if (msg.getSubject().equals("sports.event")) {
                    try {
                        // deserialize protobuf binary to event object
                        Event.event evt = Event.event.parseFrom(msg.getData());
                        logger.info(String.format("Subscribed message from %s: \n%s", msg.getSubject(), evt.toString()));
                        if (!UserStats.filterNats()) {
                            Map<String, Object> props = Collections.singletonMap("message", evt.toString());
                            chatEventFluxSink.next(new ChatEvent(
                                    ChatEvent.Type.SYSTEM_MESSAGE,
                                    new Payload(User.systemUser(), props)
                            ));
                        }

                        SportEvent sportEvent = new SportEvent();
                        sportEvent.setTimestamp(System.currentTimeMillis() / 1000);
                        sportEvent.setSport(evt.getSport().getNumber());
                        sportEvent.setMatchTitle(evt.getMatchTitle());
                        sportEvent.setDataEvent(evt.getDataEvent());
                        // save event to database table
                        eventRepository.save(sportEvent).subscribe();
                    } catch (InvalidProtocolBufferException e) {
                        logger.error(e.getMessage());
                    }
                } else if (msg.getSubject().equals("sports.execution")) {
                    try {
                        // deserialize protobuf binary to execution object
                        Execution.execution exc = Execution.execution.parseFrom(msg.getData());
                        logger.info(String.format("Subscribed message from %s: \n%s", msg.getSubject(), exc.toString()));

                        if (!UserStats.filterNats()) {
                            Map<String, Object> props = Collections.singletonMap("message", exc.toString());
                            chatEventFluxSink.next(new ChatEvent(
                                    ChatEvent.Type.SYSTEM_MESSAGE,
                                    new Payload(User.systemUser(), props)
                            ));
                        }

                        SportExecution sportExecution = new SportExecution();
                        sportExecution.setTimestamp(System.currentTimeMillis() / 1000);
                        sportExecution.setSymbol(exc.getSymbol());
                        sportExecution.setMarket(exc.getMarket());
                        sportExecution.setPrice(exc.getPrice());
                        sportExecution.setQuantity(exc.getQuantity());
                        sportExecution.setExecutionEpoch(exc.getExecutionEpoch());
                        sportExecution.setStateSymbol(exc.getStateSymbol());
                        // save execution to database table
                        executionRepository.save(sportExecution).subscribe();
                    } catch (InvalidProtocolBufferException e) {
                        logger.error(e.getMessage());
                    }
                } else {
                    logger.info(String.format("Subscribed message from %s: %s", msg.getSubject(), new String(msg.getData(), StandardCharsets.UTF_8)));
                }
            });
            // Nats subscribe to sport.event and sport.execution
            d.subscribe("sports.event");
            d.subscribe("sports.execution");
        };
    }
}
