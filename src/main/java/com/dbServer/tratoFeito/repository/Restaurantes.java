/***
 * Repositorio para Restaurante que busca o nome do restaurante passando o objeto restaurante e o tipo de @Id
 * 
 
package com.dbServer.tratoFeito.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbServer.tratoFeito.model.Restaurante;

@Repository
public interface Restaurantes extends JpaRepository<Restaurante, Long>{

	public Optional<Restaurante> findByNomeIgnoreCase(String nome);
}

*/
