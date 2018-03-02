package com.eacuji.services;

import com.eacuji.dao.AlbumDao;
import com.eacuji.entities.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao albumDao;

    @Override
    public Album findById(Long id) {
        return albumDao.findOne(id);
    }

    @Override
    public Iterable<Album> findAlbumBySingerId(Long id) {
        return albumDao.findAlbumBySingerId(id);
    }

    @Override
    public List<Album> findAll() {
        return albumDao.findAll();
    }

    @Override
    public Album save(Album a) {
        return albumDao.save(a);
    }

    @Override
    public void delete(Album a) {
        albumDao.delete(a);
    }
}
