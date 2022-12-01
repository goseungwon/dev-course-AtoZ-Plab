package com.example.plab.domain.member.mapper;

import com.example.plab.domain.member.dto.MemberDto;
import com.example.plab.entity.Member;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MemberMapper {
    public Member toMember(MemberDto memberDto) {
        return Member
                .builder()
                .name(memberDto.getName())
                .email(memberDto.getEmail())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
