package com.thingk0.wauda.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping(value = "/")
    public String mainPage(Model model) {
        model.addAttribute("showHeader", true);
        return "home";
    }

}
