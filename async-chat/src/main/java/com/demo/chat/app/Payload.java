package com.demo.chat.app;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class Payload {

    private final User user;

    private Map<String, Object> properties = new HashMap<>();

    public Payload(User user, Map<String, Object> properties){
        this(user);
        this.properties = properties;
    }
    @JsonCreator
    private Payload(@JsonProperty("user") User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @JsonAnySetter
    private void setProperties(String name, Object value){
        properties.put(name, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getProperties(){
        return properties;
    }

}
