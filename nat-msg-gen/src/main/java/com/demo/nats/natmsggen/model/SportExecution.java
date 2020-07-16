package com.demo.nats.natmsggen.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
public class SportExecution {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    private long timestamp;

    @Column
    private String symbol;

    @Column
    private String market;

    @Column
    private float price;

    @Column
    private float quantity;

    @Column(name="execution_epoch")
    private long executionEpoch;

    @Column(name="state_symbol")
    private String stateSymbol;

}

