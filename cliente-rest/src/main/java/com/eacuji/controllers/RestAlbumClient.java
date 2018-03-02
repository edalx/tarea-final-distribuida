package com.eacuji.controllers;

import com.eacuji.entities.Album;
import com.eacuji.entities.Singer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping(value = "/album")
public class RestAlbumClient {

    RestTemplate restTemplate;

    private static final String URL_GET_ALL_ALBUMS = "http://localhost:8000/api/album/";

    @PostConstruct
    public void setUp(){
        restTemplate = new RestTemplate();
    }

    @RequestMapping("/index")
    public String findAllSingers(Model model) {
        List<Album> albums = restTemplate.getForObject(URL_GET_ALL_ALBUMS + "list", List.class);
        model.addAttribute("albums", albums);
        return "album/index";
    }
}
