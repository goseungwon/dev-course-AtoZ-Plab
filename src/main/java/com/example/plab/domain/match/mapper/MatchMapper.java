package com.example.plab.domain.match.mapper;

import com.example.plab.domain.match.dto.MatchDto;
import com.example.plab.entity.Match;
import com.example.plab.entity.MatchStatus;
import org.springframework.stereotype.Component;

@Component
public class MatchMapper {

    public Match toMatch(MatchDto matchDto) {
        return Match
                .builder()
                .matchStatus(MatchStatus.RECRUIT)
                .ground(matchDto.getGroundId())
                .maxPeople(matchDto.getMaxPeople())
                .currentPeople(0)
                .matchTime(matchDto.getMatchTime())
                .build();
    }
}
