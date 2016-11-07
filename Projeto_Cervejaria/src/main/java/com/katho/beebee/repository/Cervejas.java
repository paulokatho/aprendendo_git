package com.katho.beebee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.katho.beebee.model.Cerveja;

@Repository
public interface Cervejas extends JpaRepository<Cerveja, Long> {
	//Cerveja é o Repositorio do tipo cerveja e Long é o tipo do 
	//@id da classe cerveja

	
}
