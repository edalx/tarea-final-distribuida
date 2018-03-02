package com.eacuji.dao;

import com.eacuji.entities.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SingerDao extends JpaRepository<Singer, Long> {

    @Query("select s from Singer s left join s.instruments i where i.instrumentId = :instrumentId")
    List<Singer> findByInstrumentId(@Param("instrumentId") String instrumentId);

    @Query("select s.email from Singer s")
    List<String> findAllEmails();

}