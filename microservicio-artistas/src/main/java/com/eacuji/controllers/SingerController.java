package com.eacuji.controllers;

import com.eacuji.dao.SingerDao;
import com.eacuji.entities.Instrument;
import com.eacuji.entities.Singer;
import com.eacuji.services.SingerService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/singer")
public class SingerController {
    @Autowired
    private SingerService singerService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/list")
    public List<Singer> list(){
        return singerService.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/{id}")
    public Singer findById(@PathVariable Long id){
        return singerService.findById(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/")
    public Singer save(@RequestBody Singer singer){
        return singerService.save(singer);
    }

    @DeleteMapping(value = "/")
    public void delete(@PathVariable Long id){
        Singer singer=singerService.findById(id);
        singerService.delete(singer);
    }

    @PutMapping(value = "/{id}")
    public Singer update(@PathVariable Long id, @RequestBody Singer singer){
        singer.setId(id);
        return singerService.save(singer);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/instrument/{inst}")
    public List<Singer> saludo(@PathVariable String inst){
        return singerService.findByInstrument(inst);
    }
}
