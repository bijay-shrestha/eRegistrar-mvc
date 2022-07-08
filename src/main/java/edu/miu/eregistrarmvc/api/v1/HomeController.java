package edu.miu.eregistrarmvc.api.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author bijayshrestha on 7/7/22
 * @project eRegistrar-mvc
 */
@Controller
public class HomeController {

    @GetMapping(value = {"/", "/home", "/eregistrar"})
    public String displayHomepage(){
        return "public/index";
    }
}
