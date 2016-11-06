/***
 * Classe do tipo de restaurante (Churrascaria, Massas, Food Truck
 * 
 

package com.dbServer.tratoFeito.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "tipo")
public class Tipo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotBlank(message = "Tipo é obrigatório")
	@Size(min= 1, max = 50, message = "O tamanho do tipo do restaurante não pode ser menor que {min} e maior que {max} caracteres")
	@Column(name="tipo_restaurante")
	private String tipoRestaurante;
	
	@OneToMany(mappedBy = "tipo")
	private List<Restaurante> restaurantes;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getTipo() {
		return tipoRestaurante;
	}

	public void setTipo(String tipoRestaurante) {
		this.tipoRestaurante = tipoRestaurante;
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
		Tipo other = (Tipo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
		
}

*/