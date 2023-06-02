package com.thingk0.wauda.service;

import com.thingk0.wauda.domain.Member;
import com.thingk0.wauda.dto.RegisterDto;
import com.thingk0.wauda.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * 회원가입
     */
    public Long register(RegisterDto registerDto) {
        return memberRepository.save(Member.create(registerDto, passwordEncoder)).getId();
    }

}
