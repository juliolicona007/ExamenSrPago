package com.prueba.julio.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.prueba.julio.model.InfoRQ;

@Repository
public interface InfoRQDao extends JpaRepository<InfoRQ, Long> {

}
