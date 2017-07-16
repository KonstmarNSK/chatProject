package com.kostya.chatProject.controllers;

import com.kostya.chatProject.entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Костя on 15.07.2017.
 */
@Controller
@RequestMapping("/home")
public class HomeController {
    @GetMapping
    public String getHelloHtml(Model model){
        return "home";
    }
}
