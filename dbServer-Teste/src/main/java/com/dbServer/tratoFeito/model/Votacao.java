package com.dbServer.tratoFeito.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "votar")
public class Votacao implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotNull(message = "O restaurante é obrigatório.")
	@Enumerated(EnumType.STRING)//String grava o nome "Internacioanal/Nacional" e Ordinal "0/1"
	private RestauranteEnum restaurante;
	
	
	@NotNull(message = "O usuário é obrigatório.")
	@Enumerated(EnumType.STRING)
	private UsuarioEnum usuario;
	
	
	/*** 
	 * Se fosse utilizar o mapeamento com relacionamento para restaurante e usuario
	 * 
	@ManyToOne
	@JoinColumn(name = "codigo_usuario")
	private Usuario usuario;
	
	@NotNull(message = "O restaurante é obrigatório.")
	@ManyToOne
	@JoinColumn(name = "codigo_restaurante")
	private Restaurante restaurante;
	
	*/

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public RestauranteEnum getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(RestauranteEnum restaurante) {
		this.restaurante = restaurante;
	}

	public UsuarioEnum getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEnum usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Votacao other = (Votacao) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
	

}
