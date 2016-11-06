package com.dbServer.tratoFeito.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dbServer.tratoFeito.model.Votacao;
import com.dbServer.tratoFeito.repository.Votacoes;

@Service
public class CadastroVotacaoService {
	
	@Autowired
	private Votacoes votacoes;
	
	@Transactional //qdo salvar for chamado inicia a transação que já esta configurada no jpaConfig
	public void salvar(Votacao votacao) {
		votacoes.save(votacao);
	}

}
