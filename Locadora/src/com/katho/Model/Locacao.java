package com.katho.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Locacao {
	
	private List<Filme> filmes;
	private Cliente cliente; // criar a classe cliente tambem
	private LocalDateTime data;// imagine que o dono da locadora um dia queira saber qual periodo ele aluga mais filmes, e com horario fica mais fácil gerar esssa informação
	private Devolucao devolucao;
	
	//no caso no construtor só precisamos de filmes e clientes, pois data e devolucao calculamos depois
	public Locacao(List<Filme> filme, Cliente cliente) {
		this.filmes = filme;
		this.cliente = cliente;
		//a data será pega no momento da locação então tem que pegar a hora exata do servidor
		this.data = LocalDateTime.now();
		//e como calculamos a devolucao
		// a regra é que para cada filme alugado vai incrementar um dia para devolucao, então criamos o método
		this.gerarDevolucao();
	}

	private void gerarDevolucao() {
		
		// Eu preciso somar dias em cima da quantidade de filmes e para nos auxiliar agora temos o método plus(se precisar tem o minus também)
		// 	então vai acrescentar dias em cima do filmes.size().
		// A data que eu já tenho acrescento dias com o this.filmes.size() que eu também já tenho
		// 	this.data.plusDays(this.filmes.size()
		// A data prevista será sempre às 19:00 hs. Então para gerar a dataPrevista preciso da quantidade de dias que o filme fica com a pessoa 
		// 	e a hora limite para devolução que será as 19:00 hs. 
		// como dataPrevisa é um LocalDateTime (Data e hora) preciso do método .toLocalData pra informar que é a data e localTime é a hora.
		
		// Usando as explicações acima ficaria assim, mas vamos melhorar o código
		//LocalDateTime dataPrevista = LocalDateTime.of(calcularDataPrevista(), LocalTime.of(19, 0));
		
		this.devolucao = new Devolucao(LocalDateTime.of(calcularDataPrevista(), LocalTime.of(19, 0)));
	}

	/*** Getter and Setter ***/
	
	private LocalDate calcularDataPrevista() {
		return this.data.plusDays(this.filmes.size()).toLocalDate();
	}

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

	public Devolucao getDevolucao() {
		return devolucao;
	}

	public void setDevolucao(Devolucao devolucao) {
		this.devolucao = devolucao;
	}

	public void imprimirRecibo() {
		
		System.out.printf("Obrigado %s.\n", this.cliente.getNome());
		System.out.println("Filme(s):");
		
		// aqui poderia ser iterado com lambda, mas vamos utilizar o java 7 mesmo... mas para treinar utilizar lambda
		BigDecimal total = BigDecimal.ZERO;
		for (Filme filme : this.getFilmes()) {
			System.out.println(filme.getNome());
			total = total.add(filme.getValor());
		}
		System.out.printf("Valor total: R$ %s\n", total);
		System.out.printf("Data devolução: %s"
							, this.getDevolucao().getDataPrevistaDevolucao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
		
	}
	
	
	
}
