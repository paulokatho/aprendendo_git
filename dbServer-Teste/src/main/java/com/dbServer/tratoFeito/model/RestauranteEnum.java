package com.dbServer.tratoFeito.model;

public enum RestauranteEnum {

	BRASA("Boi na Brasa"),
	MAMA("Comida da Mama");
	
	private String descricao;
	
	RestauranteEnum (String descricao) {
		this.descricao = descricao;
	}
	public String getDescricao() {
		
		return descricao;
	}
}
