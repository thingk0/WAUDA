package com.thingk0.wauda.domain;

import com.thingk0.wauda.domain.base.BaseEntity;
import com.thingk0.wauda.domain.constant.Role;
import com.thingk0.wauda.dto.MemberRegisterDto;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
@Getter
@Builder
@Table(name = "member")
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id
    @Column(name = "member_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String password;

    private String nickname;

    @Enumerated(EnumType.STRING)
    private Role role;


    /**
     * MemberRegisterDto -> Member 엔티티로 변환.
     * PasswordEncoder 를 통해 비밀번호 암호화해서 변환.
     */
    public static Member create(MemberRegisterDto dto, PasswordEncoder encoder) {
        return Member.builder()
                .email(dto.getEmail())
                .password(encoder.encode(dto.getPassword()))
                .nickname(dto.getNickname())
                .build();
    }

}
