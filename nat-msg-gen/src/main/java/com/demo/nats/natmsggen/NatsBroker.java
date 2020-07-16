package com.demo.nats.natmsggen;


import io.nats.client.Connection;
import io.nats.client.Nats;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
public class NatsBroker {

    @Bean(name="connection")
    public Connection natsConnection() throws IOException, InterruptedException {
        try {
            return Nats.connect("nats://192.168.248.4:4222");
        } catch (IOException | InterruptedException ex) {
            return null;
        }
    }

}
