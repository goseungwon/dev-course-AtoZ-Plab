package com.example.plab.domain.match.service;

import com.example.plab.domain.match.repository.MatchListRepository;
import com.example.plab.domain.match.repository.MatchRepository;
import com.example.plab.domain.member.service.MemberService;
import com.example.plab.entity.Match;
import com.example.plab.entity.MatchList;
import com.example.plab.entity.MatchStatus;
import com.example.plab.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MatchService {

    private final MatchRepository matchRepository;
    private final MatchListRepository matchListRepository;
    private final MemberService memberService;

    public List<Match> getMatches() {
        return matchRepository.findAll();
    }

    public Match getMatch(long matchId) {
        Optional<Match> match = matchRepository.findById(matchId);
        return match.orElseThrow(() -> new NoSuchElementException("존재하지 않는 match 입니다."));
    }

    @Transactional
    public MatchList joinMatch(long matchId, long memberId) {
        Match match = getMatch(matchId);
        Member member = memberService.getMemberById(memberId);
        if (match.getMaxPeople() <= match.getCurrentPeople()) {
            throw new RuntimeException("full match");
        }else {
            MatchList matchList = MatchList
                    .builder()
                    .matchId(match)
                    .memberId(member)
                    .build();

            match.setCurrentPeople(match.getCurrentPeople() + 1);
            matchRepository.save(match);
            isFullMatch(match);

            return matchListRepository.save(matchList);
        }
    }

    private void isFullMatch(Match match) {
        if (match.getMaxPeople() == match.getCurrentPeople()) {
            match.setMatchStatus(MatchStatus.MATCH_FULL);
        }
    }

    public Match createMatch(Match match) {
        return matchRepository.save(match);
    }

    public void deleteMatch(long matchId) {
        matchRepository.deleteById(matchId);
    }

    public void secessionMatch(long matchId, long memberId) {
        var match = getMatch(matchId);
        var member = memberService.getMemberById(memberId);
        matchListRepository.deleteByMatchIdAndMemberId(match, member);
    }

}
