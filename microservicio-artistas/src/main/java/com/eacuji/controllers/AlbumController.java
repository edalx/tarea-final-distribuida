package com.eacuji.controllers;

import com.eacuji.entities.Album;
import com.eacuji.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(value = "/list")
    public Iterable<Album> list(){
        return albumService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/")
    public Album save(@RequestBody Album album){
        return albumService.save(album);
    }

    @PutMapping(value = "/{id}")
    public Album update(@RequestBody Album album, @PathVariable Long id){
        album.setId(id);
        return albumService.save(album);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@RequestBody Long id){
        Album album=albumService.findById(id);
        albumService.delete(album);
    }

    @GetMapping(value = "/singer/{id}")
    public Iterable<Album> albumSinger(@RequestBody Long id){
        return albumService.findAlbumBySingerId(id);
    }


}
