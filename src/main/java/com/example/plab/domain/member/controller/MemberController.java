package com.example.plab.domain.member.controller;

import com.example.plab.domain.member.dto.MemberDto;
import com.example.plab.domain.member.service.MemberService;
import com.example.plab.entity.Member;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/api/member/new")
    public Member signUp(@RequestBody @Valid MemberDto memberDto) {
        try{
            memberService.isNameUsed(memberDto.getName());
            memberService.isEmailUsed(memberDto.getEmail());
        } catch (IllegalArgumentException e) {
            e.getCause();
        }
        return memberService.createMember(memberDto);
    }
}
