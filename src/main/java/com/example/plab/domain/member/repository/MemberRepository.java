package com.example.plab.domain.member.repository;

import com.example.plab.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByName(String name);

    List<Member> findByEmail(String email);

    @Transactional
    void removeMemberByMemberId(long memberId);
}
