package com.eacuji.services;

import com.eacuji.entities.Album;

import java.util.List;

public interface AlbumService {

    Album findById(Long id);

    Iterable<Album> findAlbumBySingerId(Long id);

    List<Album> findAll();

    Album save(Album a);

    void delete(Album a);
}
