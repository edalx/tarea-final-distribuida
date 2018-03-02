package com.eacuji.dao;

import com.eacuji.entities.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstrumentDao extends JpaRepository<Instrument, String> {
}
