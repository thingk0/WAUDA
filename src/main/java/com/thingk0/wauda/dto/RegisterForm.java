package com.thingk0.wauda.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RegisterForm {

    @Email(message = "올바른 이메일 형식으로 작성해주세요.")
    @NotEmpty(message = "이메일을 입력해주세요.")
    private String email;

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$", message = "비밀번호는 최소 8자, 최소 하나의 알파벳, 숫자, 특수문자를 포함해야 합니다.")
    @Size(min = 8, message = "비밀번호는 최소 8자 이상으로 입력해주세요.")
    @NotEmpty(message = "비밀번호를 입력해주세요.")
    private String password;

    @Size(min = 2, message = "닉네임은 최소 2자 이상으로 입력해주세요.")
    @NotEmpty(message = "닉네임을 입력해주세요.")
    private String nickname;

}
