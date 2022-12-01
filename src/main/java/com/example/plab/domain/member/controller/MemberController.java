package com.example.plab.domain.member.controller;

import com.example.plab.domain.member.dto.MemberDto;
import com.example.plab.domain.member.service.MemberService;
import com.example.plab.entity.Member;
import com.example.plab.util.response.CommonResponse;
import com.example.plab.util.response.ResponseCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/api/member/new")
    public CommonResponse<?> createMember(@RequestBody @Valid MemberDto memberDto) {
        memberService.isEmailUsed(memberDto.getEmail());
        Member member = memberService.createMember(memberDto);

        return new CommonResponse<>(member);
    }

    @PostMapping("/api/member/update")
    public CommonResponse<?> updateMember(@RequestBody @Valid Member member) {
        Member updateMember = memberService.updateMember(member);
        return new CommonResponse<>(updateMember);
    }

    @PostMapping("/api/member/{id}/delete")
    public CommonResponse<?> deleteMember(@PathVariable(name = "id") Long memberId) {
        memberService.deleteMember(memberId);
        return new CommonResponse<>("삭제 완료");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public CommonResponse<?> handleIllegalArgumentException(IllegalArgumentException exception) {
        return new CommonResponse<>(ResponseCode.EMAIL_ALREADY_USED);
    }


}
