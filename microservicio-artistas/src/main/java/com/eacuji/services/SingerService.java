package com.eacuji.services;

import com.eacuji.entities.Singer;

import java.util.List;

public interface SingerService {

    Singer save(Singer singer);

    void delete(Singer singer);

    Singer findById(Long id);

    List<Singer> findAll();

    List<Singer> findByInstrument(String instrument);

    List<String> findAllEmails();

}
