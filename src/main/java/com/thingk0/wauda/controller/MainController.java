package com.thingk0.wauda.controller;

import com.thingk0.wauda.dto.party.PartyListDto;
import com.thingk0.wauda.service.PartyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/")
public class MainController {

    private final PartyService partyService;

    @GetMapping
    public String getPartyList(@RequestParam(value = "search", required = false) String search,
                               Pageable pageable, Model model) {

        Page<PartyListDto> partyList = partyService.getPartyList(search, pageable);
        model.addAttribute("showHeader", true);
        model.addAttribute("parties", partyList.getContent());
        model.addAttribute("search", search);

        return "home";
    }

}
