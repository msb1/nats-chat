package com.demo.chat.model;

import com.demo.chat.app.ChatEvent;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Document(collection = "chat")
@Data
@NoArgsConstructor

public class Chat {

    @Id
    private String id;
    private ChatEvent.Type type;
    private String user;
    private long timestamp;
    private Map<String, Object> payload;

    public Chat(ChatEvent.Type type, String user, long timestamp, Map<String, Object> payload) {
        this.type = type;
        this.user = user;
        this.timestamp = timestamp;
        this.payload = payload;
    }
}
