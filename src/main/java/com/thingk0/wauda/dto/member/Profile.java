package com.thingk0.wauda.dto.member;

import com.thingk0.wauda.domain.constant.Role;
import lombok.Data;

@Data
public class Profile {

    private Long id;
    private String email;
    private String nickname;
    private Role role;

    public Profile(Long id, String email, String nickname, Role role) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
        this.role = role;
    }
}
