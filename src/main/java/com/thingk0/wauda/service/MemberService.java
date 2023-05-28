package com.thingk0.wauda.service;

import com.thingk0.wauda.domain.Member;
import com.thingk0.wauda.dto.MemberRegisterDto;
import com.thingk0.wauda.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    /**
     * 회원가입
     */
    public Long register(MemberRegisterDto memberRegisterDto) {
        return memberRepository.save(Member.create(memberRegisterDto, passwordEncoder)).getId();
    }

    @Transactional(readOnly = true)
    public Member findMemberByEmail(String email) {
        Member findMember = memberRepository.findByEmail(email).orElseThrow(
                () -> new EntityNotFoundException("해당하는 이메일의 회원을 찾을 수 없습니다.")
        );

        return findMember;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member findMember = findMemberByEmail(email);
        return new MemberDetails(findMember);
    }

}
