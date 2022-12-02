package com.example.plab.domain.match.controller;

import com.example.plab.domain.match.dto.MatchDto;
import com.example.plab.domain.match.mapper.MatchMapper;
import com.example.plab.domain.match.service.MatchService;
import com.example.plab.entity.Match;
import com.example.plab.util.response.CommonResponse;
import com.example.plab.util.response.ResponseCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequiredArgsConstructor
public class MatchController {

    private final MatchService matchService;

    private final MatchMapper matchMapper;

    @GetMapping("/api/match")
    public CommonResponse<?> showMatches() {
        List<Match> matches = matchService.getMatches();
        return new CommonResponse<>(matches);
    }

    @GetMapping("/api/match/{matchId}")
    public CommonResponse<?> showMatchInfo(@PathVariable long matchId) {
        Match match = matchService.getMatch(matchId);
        return new CommonResponse<>(match);
    }

    @PostMapping("/api/match/{matchId}/join/{memberId}")
    public CommonResponse<?> joinMatch(@PathVariable long matchId, @PathVariable long memberId) {
        var matchList = matchService.joinMatch(matchId, memberId);
        return new CommonResponse<>(matchList);
    }

    @PostMapping("/api/match/{matchId}/secession/{memberId}")
    public CommonResponse<?> secessionMatch(@PathVariable long matchId, @PathVariable long memberId) {
        matchService.secessionMatch(matchId, memberId);
        return new CommonResponse<>("삭제 완료");
    }

    @PostMapping("/api/match/new")
    public CommonResponse<?> createMatch(@RequestBody @Valid MatchDto matchDto) {
        var match = matchMapper.toMatch(matchDto);
        var createdMatch = matchService.createMatch(match);
        return new CommonResponse<>(createdMatch);
    }

    @PostMapping("/api/match/{matchId}/delete")
    public CommonResponse<?> deleteMatch(@PathVariable long matchId) {
        matchService.deleteMatch(matchId);
        return new CommonResponse<>("match 삭제 완료");
    }


    @ExceptionHandler(NoSuchElementException.class)
    public CommonResponse<?> handleNoSuchElementException(NoSuchElementException exception) {
        return new CommonResponse<>(ResponseCode.NOT_FOUND_MATCH);
    }

//    @ExceptionHandler(RuntimeException.class)
//    public CommonResponse<?> handleRuntimeException(RuntimeException exception) {
//        return new CommonResponse<>(ResponseCode.FULL_MATCH);
//    }
}
