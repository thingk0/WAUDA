package com.thingk0.wauda.controller;

import com.thingk0.wauda.dto.RegisterDto;
import com.thingk0.wauda.dto.RegisterForm;
import com.thingk0.wauda.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/members")
public class MemberController {

    private final MemberService memberService;

    @GetMapping(value = "/login")
    public String login(@SessionAttribute(name = "errorMessage", required = false) String errorMessage,
                        HttpServletRequest request,
                        Model model) {

        if (errorMessage != null) {
            model.addAttribute("errorMessage", errorMessage);
            request.getSession().removeAttribute("errorMessage");
            log.info("로그인 에러 발생");
        }

        log.info("로그인");
        return "login";
    }


    @GetMapping(value = "/signup")
    public String register(Model model) {
        model.addAttribute("registerForm", new RegisterForm());
        log.info("회원가입 폼");
        return "signup";
    }


    @PostMapping(value = "/signup")
    public String register(
            @Valid RegisterForm registerForm,
            BindingResult bindingResult,
            Model model
    ) {

        // 유효성 검사, 모든 에러 메시지를 파싱해서 에러 메시지를 생성
        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(", "));

            model.addAttribute("errorMsg", errorMsg);
            model.addAttribute("registerForm", registerForm);

            log.error("회원가입 실패");
            return "signup";
        }

        // 새 회원 정보를 등록
        memberService.register(new RegisterDto(
                registerForm.getEmail(),
                registerForm.getPassword(),
                registerForm.getNickname()
        ));

        log.info("회원가입");
        return "redirect:/members/login";
    }
}
