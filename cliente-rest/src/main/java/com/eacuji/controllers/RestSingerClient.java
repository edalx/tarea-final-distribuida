package com.eacuji.controllers;

import com.eacuji.entities.Singer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;


import javax.annotation.PostConstruct;
import javax.naming.Binding;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/singer")
public class RestSingerClient {

    RestTemplate restTemplate;

    private static final String URI_SINGERS = "http://localhost:8000/api/singer";

    @PostConstruct
    public void setUp() {
        restTemplate = new RestTemplate();
    }

    @GetMapping("/index")
    public String findAllSingers(Model model) {
        List<Singer> singers = restTemplate.getForObject(URI_SINGERS + "/list", List.class);
        model.addAttribute("singers", singers);
        model.addAttribute("newSinger",new Singer());
        return "singer/index";
    }

    @PostMapping("/save")
    public String singerSubmit(@Valid Singer singer, BindingResult bindingResult, Model model) {
        System.out.println("Entra al método");
        restTemplate.postForEntity(URI_SINGERS+"/",singer,Singer.class);
        return "index";
    }
}
