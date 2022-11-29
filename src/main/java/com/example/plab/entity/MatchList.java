package com.example.plab.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "match_list")
public class MatchList {

    @Id
    @GeneratedValue
    private long sequence;

    @Column(name = "member_id", nullable = false, unique = true)
    private long memberId;

    @Column(name = "match_id", nullable = false, unique = true)
    private long matchId;

    @Column(name = "match_time", nullable = false)
    private LocalDateTime matchTime;
}
