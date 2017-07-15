package com.kostya.chatProject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Костя on 15.07.2017.
 */
@Controller
@RequestMapping("/hello")
public class HelloController {
    @GetMapping
    public String getHelloHtml(){
        return "hello";
    }
}
