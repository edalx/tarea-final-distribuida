package com.eacuji.services;

import com.eacuji.entities.Instrument;

import java.util.List;

public interface InstrumentService {

    Instrument save(Instrument instrument);

    void delete(Instrument instrument);

    Instrument findById(String instrument);

    List<Instrument> findAll();

}
