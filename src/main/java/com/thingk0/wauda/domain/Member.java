package com.thingk0.wauda.domain;

import com.thingk0.wauda.domain.base.BaseEntity;
import lombok.*;

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

}
