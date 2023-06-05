package com.thingk0.wauda.service;


import com.thingk0.wauda.domain.Member;
import com.thingk0.wauda.dto.register.RegisterDto;
import com.thingk0.wauda.repository.MemberRepository;
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
        RegisterDto registerDto = new RegisterDto("member@naver.com", "12341234", "member");

        // when
        Long savedMemberId = memberService.register(registerDto);
        Member findMemberById = memberRepository.findById(savedMemberId).orElseThrow(() -> new EntityNotFoundException("Not Found"));

        // then
        assertThat(findMemberById.getEmail()).isEqualTo(registerDto.getEmail());
        assertThat(passwordEncoder.matches(registerDto.getPassword(), findMemberById.getPassword())).isTrue();
    }

}