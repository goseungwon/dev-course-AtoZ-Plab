package com.example.plab.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "MATCH_LIST")
public class MatchList {

    @Id
    @GeneratedValue
    private long sequence;

    @JoinColumn(name = "member_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Member memberId;

    @JoinColumn(name = "match_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Match matchId;

    @Column(name = "match_time", nullable = false)
    private LocalDateTime matchTime;
}
