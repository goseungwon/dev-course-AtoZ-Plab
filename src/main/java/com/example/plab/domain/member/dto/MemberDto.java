package com.example.plab.domain.member.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

@RequiredArgsConstructor
@Getter
public class MemberDto {

    @NotBlank
    @Length(max = 20)
    private String name;

    @Email
    @NotBlank
    private String email;
}
