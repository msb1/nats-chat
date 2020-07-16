package com.demo.chat.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "execution")
@Data
@NoArgsConstructor
public class SportExecution {

    @Id
    private String id;
    private long timestamp;
    private String symbol;
    private String market;
    private float price;
    private float quantity;
    private long executionEpoch;
    private String stateSymbol;

}

