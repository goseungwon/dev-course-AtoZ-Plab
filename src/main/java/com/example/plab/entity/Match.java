package com.example.plab.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "MATCH")
public class Match {

    @Id
    @GeneratedValue
    @Column(name = "match_id")
    private long matchId;

    @Column(name = "match_status", nullable = false)
    private MatchStatus matchStatus;

    @JoinColumn(name = "ground_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Ground groundId;

    @Column(name = "max_people", nullable = false)
    private int maxPeople;

    @Column(name = "current_people", nullable = false)
    @ColumnDefault("0")
    private int currentPeople;

    @Column(name = "match_time", nullable = false)
    private LocalDateTime matchTime;
}
