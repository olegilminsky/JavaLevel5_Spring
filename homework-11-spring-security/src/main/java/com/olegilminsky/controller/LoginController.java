package com.olegilminsky.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/access_denied")
    public String accessDenied() {
        return "access_denied";
    }
}
