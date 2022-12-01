package com.example.plab.domain.member.controller;

import com.example.plab.domain.member.dto.MemberDto;
import com.example.plab.domain.member.service.MemberService;
import com.example.plab.entity.Member;
import com.example.plab.util.response.CommonResponse;
import com.example.plab.util.response.ResponseCode;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

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

    @GetMapping("/api/member/{memberId}")
    public CommonResponse<?> getMemberInfo(@PathVariable Long memberId) {
        Member member = memberService.getMemberById(memberId);
        return new CommonResponse<>(member);
    }

    @PostMapping("/api/member/{memberId}/update")
    public CommonResponse<?> updateMember(@PathVariable Long memberId, @RequestBody @Valid Member member) {
        Member updateMember = memberService.updateMember(member);
        return new CommonResponse<>(updateMember);
    }

    @PostMapping("/api/member/{memberId}/delete")
    public CommonResponse<?> deleteMember(@PathVariable Long memberId) {
        memberService.deleteMember(memberId);
        return new CommonResponse<>("Member 삭제 완료.");
    }

    @GetMapping("/api/member")
    public CommonResponse<?> showMembers() {
        List<Member> members = memberService.getMembers();
        return new CommonResponse<>(members);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public CommonResponse<?> handleIllegalArgumentException(IllegalArgumentException exception) {
        return new CommonResponse<>(ResponseCode.EMAIL_ALREADY_USED);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public CommonResponse<?> handleNoSuchElementException(NoSuchElementException exception) {
        return new CommonResponse<>(ResponseCode.NOT_FOUND_MEMBER);
    }


}
