package com.example.plab.domain.match.repository;

import com.example.plab.entity.Match;
import com.example.plab.entity.MatchList;
import com.example.plab.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MatchListRepository extends JpaRepository<MatchList, Long> {
    void deleteByMatchIdAndMemberId(Match matchId, Member memberId);
}
