package com.example.plab.domain.ground.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

@RequiredArgsConstructor
@Getter
public class GroundDto {

    @NotBlank
    @Length(max = 10)
    private String groundName;

    @NotBlank
    private String groundAddress;
}
