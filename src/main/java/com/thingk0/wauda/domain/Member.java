package com.thingk0.wauda.domain;

import com.thingk0.wauda.domain.base.BaseEntity;
import com.thingk0.wauda.domain.constant.Role;
import com.thingk0.wauda.dto.RegisterDto;
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
     * Member 생성 메서드
     * @param dto 회원가입 dto
     * @param encoder 패스워드 인코더
     */
    public static Member create(RegisterDto dto, PasswordEncoder encoder) {
        return Member.builder()
                .email(dto.getEmail())
                .password(encoder.encode(dto.getPassword()))
                .nickname(dto.getNickname())
                .role(Role.USER)
                .build();
    }

}
