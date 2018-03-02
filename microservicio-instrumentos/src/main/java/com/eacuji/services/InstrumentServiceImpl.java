package com.eacuji.services;

import com.eacuji.dao.InstrumentDao;
import com.eacuji.entities.Instrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrumentServiceImpl implements InstrumentService {
    @Autowired
    private InstrumentDao instrumentDao;

    @Override
    public Instrument save(Instrument instrument) {
        return instrumentDao.save(instrument);
    }

    @Override
    public void delete(Instrument instrument) {
        instrumentDao.delete(instrument);
    }

    @Override
    public Instrument findById(String instrument) {
        return instrumentDao.findOne(instrument);
    }

    @Override
    public List<Instrument> findAll() {
        return instrumentDao.findAll();
    }
}
