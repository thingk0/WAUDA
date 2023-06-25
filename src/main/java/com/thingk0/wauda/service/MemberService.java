package com.thingk0.wauda.service;

import com.thingk0.wauda.domain.Member;
import com.thingk0.wauda.dto.member.Profile;
import com.thingk0.wauda.dto.register.RegisterDto;
import com.thingk0.wauda.exception.EmailAlreadyExistsException;
import com.thingk0.wauda.exception.ProfileNotFoundException;
import com.thingk0.wauda.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional(readOnly = true)
    public Member findMemberByEmail(String email) {
        log.info("MemberService.findMemberByEmail");
        return memberRepository.findByEmail(email).orElseThrow(
                () -> new EntityNotFoundException("해당 이메일의 회원을 찾을 수 없습니다.")
        );
    }

    @Transactional
    public Profile getProfile(String email) throws ProfileNotFoundException {
        log.info("MemberService.getProfile");
        return memberRepository.getProfileByEmail(email).orElseThrow(
                () -> new ProfileNotFoundException("해당 아이디의 회원 프로필을 찾을 수 없습니다.")
        );
    }

    public Long register(RegisterDto registerDto) throws EmailAlreadyExistsException {
        log.info("MemberService.register");
        if (memberRepository.existsByEmail(registerDto.getEmail()))
            throw new EmailAlreadyExistsException("이미 존재하는 이메일입니다.");

        return memberRepository.save(Member.create(registerDto, passwordEncoder)).getId();
    }

}
