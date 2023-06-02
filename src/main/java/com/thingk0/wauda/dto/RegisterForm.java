package com.thingk0.wauda.dto;

import lombok.Data;

import javax.validation.constraints.*;

@Data
public class RegisterForm {

    private static final String PASSWORD_PATTERN = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";
    private static final String PASSWORD_MESSAGE = "비밀번호는 최소 8자, 최소 하나의 알파벳, 숫자, 특수문자를 포함해야 합니다.";

    @Email(message = "올바른 이메일 형식으로 작성해주세요.")
    @NotEmpty(message = "이메일을 입력해주세요.")
    private String email;

    @Pattern(regexp = PASSWORD_PATTERN, message = PASSWORD_MESSAGE)
    @Size(min = 8, message = "비밀번호는 최소 8자 이상으로 입력해주세요.")
    @NotEmpty(message = "비밀번호를 입력해주세요.")
    private String password;

    @Pattern(regexp = PASSWORD_PATTERN, message = PASSWORD_MESSAGE)
    @Size(min = 8, message = "비밀번호는 최소 8자 이상으로 입력해주세요.")
    @NotEmpty(message = "비밀번호를 입력해주세요.")
    private String passwordConfirm;

    @Size(min = 2, message = "닉네임은 최소 2자 이상으로 입력해주세요.")
    @NotEmpty(message = "닉네임을 입력해주세요.")
    private String nickname;

    @AssertTrue(message = "비밀번호가 일치하지 않습니다.")
    public boolean isPasswordsMatch() {
        return this.password != null && this.password.equals(this.passwordConfirm);
    }
}

