package com.eacuji.controllers;

import com.eacuji.mq.ProducerConfig;
import com.eacuji.entities.Instrument;
import com.eacuji.services.InstrumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/instrument")
public class InstrumentController {

    @Autowired
    private InstrumentService instrumentService;

    @Autowired
    private ProducerConfig producerConfig;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/list")
    public List<Instrument> list(){
        return instrumentService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/")
    public Instrument create(@RequestBody Instrument instrument){
        Instrument instrumentSave=instrumentService.save(instrument);
        producerConfig.sendMessage(instrumentSave);
        return instrumentSave;
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable String id){
        Instrument instrument=instrumentService.findById(id);
        instrumentService.delete(instrument);
    }
}
