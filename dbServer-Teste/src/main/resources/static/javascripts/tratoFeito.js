//modularizar o javascript

//Estamos desclarando nosso objeto global com o nome do nosso projeto

var TratoFeito = TratoFeito || {}; //verifica se já tem o objeto, se não tiver ele cria um novo

//criando a função contrutora
//1- Criamos esse nameEspace de TratoFeito declarado acima
TratoFeito.MaskMoney = (function () { 
	
	// 2- Criando a função
	function MaskMoney() { 
		
	// 3- Declarando/Inicializando as variaveis
		this.decimal = $('.js-decimal');//fica assim pois estamos inicializando no objeto
		this.plain = $('.js-plain');
	}
	
	// 4- Declarando a execução do comportamento descrito acima no this.decimal ou this.plain ... este deixamos aqui dentro do "prototype"	
	MaskMoney.prototype.enable = function() { //colocamos dentro de .enable, pois podemos criar ali em baixo uma função desable, caso seja necessário
		this.decimal.maskMoney({ decimal: ',', thousands: '.' });
		this.plain.maskMoney({precision: 0 , thousands: '.'});
		
	}
		return MaskMoney;// retornamos o resultado	
}());

	//5- Executando nosso objeto criado acima
$(function() { 
	
	//essa variavel poderia ser qq nome, esta com esse nome para facilitar e ficar mais legivel o código
	var maskMoney = new TratoFeito.MaskMoney();
	maskMoney.enable();
	
});
	 