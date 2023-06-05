package com.thingk0.wauda.service;

import com.thingk0.wauda.domain.Member;
import com.thingk0.wauda.dto.register.RegisterDto;
import com.thingk0.wauda.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public Member findMemberByEmail(String email) {
        return memberRepository.findByEmail(email).orElseThrow(
                () -> new EntityNotFoundException("해당 이메일의 회원을 찾을 수 없습니다.")
        );
    }

    public Long register(RegisterDto registerDto) {
        return memberRepository.save(Member.create(registerDto, passwordEncoder)).getId();
    }

}
