package com.dbServer.tratoFeito.model;

public enum UsuarioEnum {

	PAULO("Paulo André"),
	ANTONIA("Antonia Cardoso"),
	MARA("Mara Melão");
	
	private String descricao;
	
	UsuarioEnum (String descricao) {
		this.descricao = descricao;
	}
	public String getDescricao() {
		
		return descricao;
	}
}
