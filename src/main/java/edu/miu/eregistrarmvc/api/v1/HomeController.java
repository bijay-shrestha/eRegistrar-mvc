package edu.miu.eregistrarmvc.api.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author bijayshrestha on 7/7/22
 * @project eRegistrar-mvc
 */
@Controller
@RequestMapping(value = {"","/eregistrar"})
public class HomeController {

    @GetMapping(value = {"/", "/home", "/public/home"})
    public String displayHomepage(){
        return "public/index";
    }

    @GetMapping(value = {"/public/about"})
    public String displayAboutpage() {
        return "public/home/about";
    }
}
