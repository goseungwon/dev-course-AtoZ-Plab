package com.example.plab.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "MATCH_LIST")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatchList {

    @Id
    @GeneratedValue
    private long sequence;

    @JoinColumn(name = "member_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Member memberId;

    @JoinColumn(name = "match_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Match matchId;
}
