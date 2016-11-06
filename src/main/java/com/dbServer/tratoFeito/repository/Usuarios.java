/***
 * 
 * Respositorio de Usuario, que também esta implementado como demonstração
 * 
 

package com.dbServer.tratoFeito.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbServer.tratoFeito.model.Usuario;

@Repository
public interface Usuarios extends JpaRepository<Usuario, Long>{

	public Optional<Usuario> findByNomeIgnoreCase(String nome);
}


*/