package com.thingk0.wauda.controller;

import com.thingk0.wauda.dto.comments.CommentsForm;
import com.thingk0.wauda.dto.party.PartyForm;
import com.thingk0.wauda.service.CommentsService;
import com.thingk0.wauda.service.PartyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.stream.Collectors;


@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/party")
public class PartyController {

    private final PartyService partyService;
    private final CommentsService commentsService;


    @GetMapping(value = "/{id}")
    public String getPartyDetail(@PathVariable("id") Long id, Model model,
                                 @ModelAttribute("commentsError") String commentsError) {

        model.addAttribute("commentsError", commentsError);
        model.addAttribute("commentsForm", new CommentsForm());
        model.addAttribute("commentEnabled", "commentEnabled");

        model.addAttribute("party", partyService.getPartyDetail(id));
        model.addAttribute("commentsList", commentsService.getCommentsList(id));
        return "party_detail";
    }


    @GetMapping(value = "/create")
    public String getPartyCreateForm(Model model) {
        model.addAttribute("partyForm", new PartyForm());
        log.info("파티 생성 폼");
        return "party_create";
    }


    @PostMapping(value = "/create")
    public String partyCreate(@Valid PartyForm partyForm,
                                  BindingResult bindingResult,
                                  Authentication authentication,
                                  Model model) {

        // 유효성 검사, 모든 에러 메시지를 파싱해서 에러 메시지를 생성
        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(", "));

            model.addAttribute("errorMsg", errorMsg);
            model.addAttribute("partyForm", partyForm);

            log.error("파티 생성 폼 오류");
            return "party_create";
        }

        String email = (String) authentication.getPrincipal();
        Long savedPartyId = partyService.create(partyForm, email);

        log.info("파티 생성 id : " + savedPartyId);
        return "redirect:/";
    }



}
