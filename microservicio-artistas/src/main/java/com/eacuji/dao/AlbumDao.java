package com.eacuji.dao;

import com.eacuji.entities.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumDao extends JpaRepository<Album,Long> {

    @Query("select a from Album a left join a.singer s where s.id = :id")
    Iterable<Album> findAlbumBySingerId(@Param("id") Long id);
}
