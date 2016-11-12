package com.katho.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/***
 * 
 * @author KATHO
 * 
 * Para cada devolução gera uma nova devolução e essa devolução só acontece quando o usuário
 * 	entregar o filme. 
 * Se não no sistema fica devolução pendente.
 *
 */
public class Devolucao {

		// para o campo abaixo a regra é: para cada filme locado eu vou incrementar um dia na data prevista de locação para imprimir o recibo para ele pagar o valor.
		// e aqui também definimos que não pode devolver após as  19:00 hs, passou das 19 tem que pagar multa.
		private LocalDateTime dataPrevistaDevolucao;  
		private LocalDateTime dataRealDevolucao; //pode-se que ele atrase
		private BigDecimal valorDevolucao;
		
		public Devolucao(LocalDateTime dataPrevistaDevolucao) {			 
			this.dataPrevistaDevolucao = dataPrevistaDevolucao;
		}

		public LocalDateTime getDataPrevistaDevolucao() {
			return dataPrevistaDevolucao;
		}

		public void setDataPrevistaDevolucao(LocalDateTime dataPrevistaDevolucao) {
			this.dataPrevistaDevolucao = dataPrevistaDevolucao;
		}

		public LocalDateTime getDataRealDevolucao() {
			return dataRealDevolucao;
		}

		public void setDataRealDevolucao(LocalDateTime dataRealDevolucao) {
			this.dataRealDevolucao = dataRealDevolucao;
		}

		public BigDecimal getValorDevolucao() {
			return valorDevolucao;
		}

		public void setValorDevolucao(BigDecimal valorDevolucao) {
			this.valorDevolucao = valorDevolucao;
		}
		
		/***
		 * Foi criado uma classe Devolucao com relacionamento 1-1 para ficar mais orientado a objetos e também ficar mais simples a classe Locacao.
		 */
}
