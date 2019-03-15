package at.lingu.laravelmix.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/")
    public ModelAndView welcome() {
        ModelAndView mv = new ModelAndView("welcome");
        mv.addObject("appName", appName);
        return mv;
    }
}
