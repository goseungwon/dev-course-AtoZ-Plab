package com.example.plab.domain.match.dto;

import com.example.plab.entity.Ground;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Getter
public class MatchDto {

    @NotNull
    private Ground groundId;

    @Max(20)
    @Min(10)
    private int maxPeople;

    @NotNull
    private LocalDateTime matchTime;
}
