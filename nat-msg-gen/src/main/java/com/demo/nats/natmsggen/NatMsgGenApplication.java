package com.demo.nats.natmsggen;

import com.demo.nats.natmsggen.model.SportEvent;
import com.demo.nats.natmsggen.model.SportExecution;
import com.demo.nats.natmsggen.protobuf.Event;
import com.demo.nats.natmsggen.protobuf.Execution;
import com.demo.nats.natmsggen.repository.EventRepository;
import com.demo.nats.natmsggen.repository.ExecutionRepository;
import com.google.protobuf.InvalidProtocolBufferException;
import io.nats.client.Connection;
import io.nats.client.Dispatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.sql.DataSource;
import java.nio.charset.StandardCharsets;

@SpringBootApplication
@EntityScan(basePackages = "com.demo.nats.natmsggen.model")
@EnableScheduling
public class NatMsgGenApplication implements ApplicationRunner {

	private static final Logger logger = LoggerFactory.getLogger(NatMsgGenApplication.class);
	@Autowired
	@Qualifier("connection")
	private Connection natsConnection;

	@Autowired
	private DataSource dataSource;

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private ExecutionRepository executionRepository;

	public static void main(String[] args) {
		SpringApplication.run(NatMsgGenApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {
		eventRepository.deleteAll();
		executionRepository.deleteAll();

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
					SportEvent sportEvent = new SportEvent();
					sportEvent.setTimestamp(System.currentTimeMillis() / 1000);
					sportEvent.setSport(evt.getSport().getNumber());
					sportEvent.setMatchTitle(evt.getMatchTitle());
					sportEvent.setDataEvent(evt.getDataEvent());
					// save event to database table
					eventRepository.save(sportEvent);
				} catch (InvalidProtocolBufferException e) {
					logger.error(e.getMessage());
				}
			} else if (msg.getSubject().equals("sports.execution")) {
				try {
					// deserialize protobuf binary to execution object
					Execution.execution exc = Execution.execution.parseFrom(msg.getData());
					logger.info(String.format("Subscribed message from %s: \n%s", msg.getSubject(), exc.toString()));
					SportExecution sportExecution = new SportExecution();
					sportExecution.setTimestamp(System.currentTimeMillis() / 1000);
					sportExecution.setSymbol(exc.getSymbol());
					sportExecution.setMarket(exc.getMarket());
					sportExecution.setPrice(exc.getPrice());
					sportExecution.setQuantity(exc.getQuantity());
					sportExecution.setExecutionEpoch(exc.getExecutionEpoch());
					sportExecution.setStateSymbol(exc.getStateSymbol());
					// save execution to database table
					executionRepository.save(sportExecution);
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
	}
}
