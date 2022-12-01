package com.example.plab.domain.member.service;

import com.example.plab.domain.member.dto.MemberDto;
import com.example.plab.domain.member.mapper.MemberMapper;
import com.example.plab.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Transactional
    public Member createMember(MemberDto memberDto) {
        Member member = memberMapper.toMember(memberDto);
        return memberRepository.save(member);
    }

    public void isNameUsed(String name) {
        List<Member> members = memberRepository.findByName(name);
        if (members.size() != 0) {
            throw new IllegalArgumentException("name is already used");
        }
    }

        public void isEmailUsed (String email){
            List<Member> members = memberRepository.findByEmail(email);
            if (members.size() != 0) {
                throw new IllegalArgumentException("email is already used");
            }
        }
    }
