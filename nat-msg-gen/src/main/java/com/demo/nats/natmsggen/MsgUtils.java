package com.demo.nats.natmsggen;

import com.demo.nats.natmsggen.protobuf.Event;
import com.demo.nats.natmsggen.protobuf.Execution;

import java.util.Random;

public class MsgUtils {

    private final Random rv = new Random();

    public Event.event genEvent() {
        Event.sport sport = Event.sport.forNumber(rv.nextInt(7) + 1);
        Event.event.Builder ev = Event.event.newBuilder();
        ev.setSport(sport);
        ev.setMatchTitle(sport.name() + " Match Title: "  + randomString(rv.nextInt(15)));
        ev.setDataEvent(sport.name() + " Data Event: "  + randomString(rv.nextInt(25)));
        return ev.build();
    }

    public Execution.execution genExecution() {
        Execution.execution.Builder exc = Execution.execution.newBuilder();
        exc.setSymbol(randomSymbol(4));
        exc.setMarket(randomSymbol(8));
        exc.setPrice(rv.nextFloat() * 200.0F);
        exc.setQuantity(rv.nextInt(1000));
        exc.setExecutionEpoch(System.currentTimeMillis() / 1000);
        exc.setStateSymbol(randomSymbol(6));
        return exc.build();
    }

    // private helper method - random string generator
    private String randomString(final int len) {
        final StringBuilder sb = new StringBuilder();
        final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        final int strlen = alphabet.length();

        for (int i = 0; i < len; ++i) {
            sb.append(alphabet.charAt(rv.nextInt(strlen)));
        }
        return sb.toString();
    }

    private String randomSymbol(final int len) {
        final StringBuilder sb = new StringBuilder();
        final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        final int strlen = alphabet.length();

        for (int i = 0; i < len; ++i) {
            sb.append(alphabet.charAt(rv.nextInt(strlen)));
        }
        return sb.toString();
    }
}
