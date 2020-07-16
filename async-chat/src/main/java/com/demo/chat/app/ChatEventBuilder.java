package com.demo.chat.app;

import java.util.HashMap;
import java.util.Map;

public class ChatEventBuilder {

    private ChatEvent.Type type;
    private final PayloadBuilder payloadBuilder = new PayloadBuilder();

    public ChatEventBuilder type(ChatEvent.Type type) {
        this.type = type;
        return this;
    }

    public PayloadBuilder withPayload() {
        return payloadBuilder;
    }

    private ChatEvent buildEvent(Payload payload) {
        return new ChatEvent(type, payload);
    }

    protected class PayloadBuilder {

        private String alias;
        private boolean filter;
        private final Map<String, Object> properties = new HashMap<>();

        public PayloadBuilder userAlias(String alias) {
            this.alias = alias;
            return this;
        }

        public PayloadBuilder userFilter(boolean filter) {
            this.filter = filter;
            return this;
        }

        public PayloadBuilder user(User user) {
            this.alias = user.getAlias();
            this.filter = user.isFilter();
            return this;
        }

        public PayloadBuilder systemUser() {
            user(User.systemUser());
            return this;
        }

        public PayloadBuilder property(String property, Object value) {
            properties.put(property, value);
            return this;
        }

        public ChatEvent build() {
            return buildEvent(new Payload(new User(payloadBuilder.alias, payloadBuilder.filter), properties));
        }
    }
}
