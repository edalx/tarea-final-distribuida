package com.eacuji.services;

import com.eacuji.dao.SingerDao;
import com.eacuji.entities.Singer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SingerServiceImpl implements SingerService{

    @Autowired
    private SingerDao singerDao;

    @Override
    public Singer save(Singer singer) {
        return singerDao.save(singer);
    }

    @Override
    public void delete(Singer singer) {
        singerDao.delete(singer);
    }

    @Override
    public Singer findById(Long id) {
        return singerDao.findOne(id);
    }

    @Override
    public List<Singer> findAll() {
        return singerDao.findAll();
    }

    @Override
    public List<Singer> findByInstrument(String instrument) {
        return singerDao.findByInstrumentId(instrument);
    }

    @Override
    public List<String> findAllEmails() {
        return singerDao.findAllEmails();
    }
}
