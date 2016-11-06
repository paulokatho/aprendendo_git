package com.dbServer.tratoFeito.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbServer.tratoFeito.model.Votacao;

@Repository
public interface Votacoes extends JpaRepository<Votacao, Long>{

	
}
