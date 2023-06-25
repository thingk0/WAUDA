package com.thingk0.wauda.dto.member;

import com.thingk0.wauda.domain.constant.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    private Long id;
    private String email;
    private String nickname;
    private Role role;
}
