package com.thingk0.wauda.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request,
                                        HttpServletResponse response,
                                        AuthenticationException exception)
            throws IOException, ServletException {

        log.error("로그인 실패: 아이디나 비밀번호가 잘못되었습니다.");

        // 로그인 실패에 대한 로직 구현.
        request.getSession().setAttribute("errorMessage", "로그인 실패: 아이디나 비밀번호가 잘못되었습니다.");
        // 로그인 실패 시 리다이렉트 할 URL 지정
        response.sendRedirect("/members/login/error");
    }
}

