package com.thingk0.wauda.service;


import com.thingk0.wauda.domain.Member;
import com.thingk0.wauda.dto.MemberRegisterDto;
import com.thingk0.wauda.repository.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
@ActiveProfiles("test")
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("회원가입 테스트")
    public void registerTest() {
        // given
        MemberRegisterDto memberRegisterDto = new MemberRegisterDto("member@naver.com", "12341234", "member");

        // when
        Long savedMemberId = memberService.register(memberRegisterDto);
        Member findMemberById = memberRepository.findById(savedMemberId).orElseThrow(() -> new EntityNotFoundException("Not Found"));

        // then
        assertThat(findMemberById.getEmail()).isEqualTo(memberRegisterDto.getEmail());
        assertThat(passwordEncoder.matches(memberRegisterDto.getPassword(), findMemberById.getPassword())).isTrue();
    }

}