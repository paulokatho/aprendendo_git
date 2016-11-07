package com.katho.beebee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.katho.beebee.model.Cerveja;
import com.katho.beebee.repository.Cervejas;

//Anotação que informa que é uma classe de serviço, que existem regras de negocio
@Service
public class CadastroCervejaService {

	@Autowired
	private Cervejas cervejas;
	
	@Transactional //qdo salvar for chamado inicia a transação que já esta configurada no jpaConfig
	public void salvar(Cerveja cerveja) {
		cervejas.save(cerveja);
	}
}
