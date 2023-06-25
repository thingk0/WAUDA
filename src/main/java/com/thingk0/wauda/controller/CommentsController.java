package com.thingk0.wauda.controller;

import com.thingk0.wauda.dto.comments.CommentsForm;
import com.thingk0.wauda.service.CommentsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/comments")
public class CommentsController {

    private final CommentsService commentsService;

    @PostMapping
    public String addComments(@Valid @ModelAttribute CommentsForm commentsForm,
                              BindingResult bindingResult, Authentication authentication,
                              RedirectAttributes redirectAttributes, Model model) {

        if (bindingResult.hasErrors()) {
            String errorMsg = bindingResult.getAllErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .collect(Collectors.joining(", "));

            redirectAttributes.addFlashAttribute("commentsError", errorMsg);
        } else {
            commentsService.addComment(commentsForm, (String) authentication.getPrincipal());
        }

        return String.format("redirect:/party/%d", commentsForm.getPartyId());
    }

}
