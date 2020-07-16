package com.demo.nats.natmsggen;

import com.demo.nats.natmsggen.protobuf.Event;
import com.demo.nats.natmsggen.protobuf.Execution;
import io.nats.client.Connection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
public class GenMessage {

    private static final Logger logger = LoggerFactory.getLogger(GenMessage.class);
    private final MsgUtils msgUtils = new MsgUtils();

    @Autowired
    @Qualifier("connection")
    public Connection natsConnection;

    @Scheduled(fixedRate = 500)
    public void event() throws UnsupportedEncodingException {
        if (natsConnection == null) {
            logger.error("Nats Broker connection not made. Please correct and restart app...");
            return;
        }
        Event.event evt = msgUtils.genEvent();
        natsConnection.publish("sports.event", evt.toByteArray());
        logger.info("sports.event Nats msg sent: \n" + evt.toString());
    }

    @Scheduled(fixedRate = 1200)
    public void execution(){
        if (natsConnection == null) {
            logger.error("Nats Broker connection not made. Please correct and restart app...");
            return;
        }
        Execution.execution exc = msgUtils.genExecution();
        natsConnection.publish("sports.execution", exc.toByteArray());
        logger.info("sports.execution Nats msg sent: \n" + exc.toString());
    }
}