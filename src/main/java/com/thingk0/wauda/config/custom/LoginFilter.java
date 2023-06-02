package com.thingk0.wauda.config.custom;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter extends UsernamePasswordAuthenticationFilter {

    public LoginFilter() {
        setFilterProcessesUrl("/member/login/process");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        return super.getAuthenticationManager().authenticate(
                new UsernamePasswordAuthenticationToken(
                        obtainUsername(request),
                        obtainPassword(request)));
    }
}
