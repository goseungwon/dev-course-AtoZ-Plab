package com.example.plab.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Matches {

    @Id
    @GeneratedValue
    @Column(name = "match_id")
    private long matchId;

    @Column(name = "match_status")
    private MatchStatus matchStatus;

    @Column(name = "ground_address", nullable = false)
    private String groundAddress;

    @Column(name = "max_people", nullable = false)
    private int maxPeople;

    @Column(name = "current_people")
    private int currentPeople;

    @Column(name = "match_time", nullable = false)
    private LocalDateTime matchTime;
}
