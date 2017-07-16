package com.kostya.chatProject.controllers.authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Костя on 16.07.2017.
 */

@Controller
public class LoginController {
    @RequestMapping("/login")
    public String getPage(){
        return "login";
    }
}
