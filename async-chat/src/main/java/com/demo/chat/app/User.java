package com.demo.chat.app;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

    private final String alias;
    private final boolean filter;

    public static User systemUser(){
        return new User("System", false);
    }

    @JsonCreator
    public User(@JsonProperty("alias") String alias, @JsonProperty("isFilter") boolean filter) {
        this.alias = alias;
        this.filter = filter;
    }

    public String getAlias() {
        return alias;
    }
    public boolean isFilter() {
        return filter;
    }

}
