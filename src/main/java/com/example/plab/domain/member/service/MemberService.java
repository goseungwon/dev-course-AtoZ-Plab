package com.example.plab.domain.member.service;

import com.example.plab.domain.member.dto.MemberDto;
import com.example.plab.domain.member.mapper.MemberMapper;
import com.example.plab.domain.member.repository.MemberRepository;
import com.example.plab.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    public Member createMember(MemberDto memberDto) {
        Member member = memberMapper.toMember(memberDto);
        return memberRepository.save(member);
    }

    public Member updateMember(Member member) {
        return memberRepository.save(member);
    }

    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }

    public void isEmailUsed(String email) {
        List<Member> members = memberRepository.findByEmail(email);
        if (members.size() != 0) {
            throw new IllegalArgumentException("email is already used");
        }
    }

    public List<Member> getMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberById(Long memberId) {
        Optional<Member> member = memberRepository.findById(memberId);
        return member.orElseThrow(() -> new NoSuchElementException("존재하지 않는 member 입니다."));
    }
}
