package com.demo.nats.natmsggen.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
public class SportEvent {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column
    private long timestamp;

    @Column(name="sport")
    private int sport;

    @Column(name="match_title")
    private String matchTitle;

    @Column(name="data_event")
    private String dataEvent;
}
