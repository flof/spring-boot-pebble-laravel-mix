package com.kuzoncby.mix.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/")
    public ModelAndView welcome() {
        ModelAndView mv = new ModelAndView("welcome");
        mv.addObject("greeting", "Spring Boot and Laravel Mix");
        return mv;
    }
}
