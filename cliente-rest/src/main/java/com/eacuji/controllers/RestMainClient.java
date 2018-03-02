package com.eacuji.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class RestMainClient {

    @RequestMapping("/")
    public String inicio() {
        return "index";
    }
}
