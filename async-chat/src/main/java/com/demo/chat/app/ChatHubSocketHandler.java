package com.demo.chat.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;
import reactor.core.publisher.UnicastProcessor;

import java.io.IOException;
import java.util.Optional;

import static com.demo.chat.app.ChatEvent.Type.USER_LEFT;

public class ChatHubSocketHandler implements WebSocketHandler {

    private final UnicastProcessor<ChatEvent> eventPublisher;
    private final Flux<String> outputEvents;
    private final ObjectMapper mapper;

    public ChatHubSocketHandler(UnicastProcessor<ChatEvent> eventPublisher, Flux<ChatEvent> events) {
        this.eventPublisher = eventPublisher;
        this.mapper = new ObjectMapper();
        this.outputEvents = Flux.from(events).map(this::toJSON);
    }

    @Override
    public Mono<Void> handle(WebSocketSession session) {
        WebSocketMessageSubscriber subscriber = new WebSocketMessageSubscriber(eventPublisher);
        return session.receive()
                .map(WebSocketMessage::getPayloadAsText)
                .map(this::toEvent)
                .doOnNext(subscriber::onNext)
                .doOnError(subscriber::onError)
                .doOnComplete(subscriber::onComplete)
                .zipWith(session.send(outputEvents.map(session::textMessage)))
                .then();
    }


    private ChatEvent toEvent(String json) {
        try {
            return mapper.readValue(json, ChatEvent.class);
        } catch (IOException e) {
            throw new RuntimeException("Invalid JSON:" + json, e);
        }
    }

    private String toJSON(ChatEvent event) {
        try {
            return mapper.writeValueAsString(event);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    private static class WebSocketMessageSubscriber {
        // private final UnicastProcessor<ChatEvent> eventPublisher;
        private final FluxSink<ChatEvent> chatEventFluxSink;
        private Optional<ChatEvent> lastReceivedEvent = Optional.empty();

        public WebSocketMessageSubscriber(UnicastProcessor<ChatEvent> eventPublisher) {
            // this.eventPublisher = eventPublisher;
            this.chatEventFluxSink = eventPublisher.sink();
        }

        public void onNext(ChatEvent event) {
            lastReceivedEvent = Optional.of(event);
            chatEventFluxSink.next(event);
            // eventPublisher.onNext(event);
        }

        public void onError(Throwable error) {
            //TODO log error
            error.printStackTrace();
        }

        public void onComplete() {

            //lastReceivedEvent.ifPresent(event -> eventPublisher.onNext(
            lastReceivedEvent.ifPresent(event -> chatEventFluxSink.next(
                    ChatEvent.type(USER_LEFT)
                            .withPayload()
                            .user(event.getUser())
                            .build()));
        }

    }
}
