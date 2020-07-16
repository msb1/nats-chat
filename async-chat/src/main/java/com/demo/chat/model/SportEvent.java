package com.demo.chat.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "event")
@Data
@NoArgsConstructor

public class SportEvent {

    @Id
    private String id;
    private long timestamp;
    private int sport;
    private String matchTitle;
    private String dataEvent;
}
