/***
	 * Caso fosse implementar a classe Restaurante com validações e relacionamentos
	 * 

package com.dbServer.tratoFeito.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "restaurante")
public class Restaurante implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long codigo;
	
	@NotBlank(message = "O nome do restaurante é obrigatório.")
	private String nome;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	 
	@NotNull( message = "A rua e número são obrigatórios.")
	@Column( name = "rua_numero")
	private String ruaNumero;
	
	@NotNull( message = "O bairro é obrigatório.")
	private String bairro;
	
	@NotNull( message = "O telefone é obrigatório.")
	private String telefone;
	
	@NotNull( message = "O valor aproximado da refeição é obrigatório.")
	@DecimalMin(value = "0.50", message = "O valor da refeição dever ser maior que R$0,50")
	@DecimalMax(value = "9999.99", message = "O valor da cerveja deve ser menor que R$9.999,99")
	@Column( name = "valor_refeicao")
	private BigDecimal valorRefeicao;
	
	@NotNull( message = "O tipo do restaurante é obrigatório.")
	@ManyToOne
	@JoinColumn(name = "codigo_tipo")
	private Tipo tipo;
	
	@OneToMany(mappedBy = "restaurante")
	private List<Votacao> votacoes;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRuaNumero() {
		return ruaNumero;
	}

	public void setRuaNumero(String ruaNumero) {
		this.ruaNumero = ruaNumero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public BigDecimal getValorRefeicao() {
		return valorRefeicao;
	}

	public void setValorRefeicao(BigDecimal valorRefeicao) {
		this.valorRefeicao = valorRefeicao;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
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
		Restaurante other = (Restaurante) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}
	
}

*/
