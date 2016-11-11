var BeeBee = BeeBee || {}; // caso não exista o objeto ele cria um novo objeto

BeeBee.UploadFoto = (function() {
	
	function UploadFoto() { // função construtora do uploadFoto
		
		this.inputNomeFoto = $('input[name=foto]');
		this.inputContentType = $('input[name=contentType]');
		
		this.htmlFotoCervejaTemplate = $('#foto-cerveja').html();
		this.template = Handlebars.compile(this.htmlFotoCervejaTemplate); // esse pode demorar um pouco mais para iniciarlizar então é bom deixar no começo
		
		//this.htmlFotoCerveja = template({nomeFoto: resposta.nome}); // template não iniciliza agora, ele será inicializado no prototype na função onUploadCompleto()
		
		this.containerFotoCerveja = $('.js-container-foto-cerveja');
		
		this.uploadDrop = $('#upload-drop');
		
	}
	
	UploadFoto.prototype.iniciar = function () {
		var settings = {
			type: 'json',
			filelimit: 1,
			allow: '*.(jpg|jpeg|png)',
			action: this.containerFotoCerveja.data('url-fotos'),
			complete: onUploadCompleto.bind(this) // esse (this) acessa todos os this. que tem no método construtor e não esquecer de criar a função onUploadCompleto()
			
		}
		UIkit.uploadSelect($('#upload-select'), settings);
		UIkit.uploadDrop(this.uploadDrop, settings);
	}
	
	function onUploadCompleto(resposta) {
		this.inputNomeFoto.val(resposta.nome);
		this.inputContentType.val(resposta.contenType);	
		
		this.uploadDrop.addClass('hidden');
		var htmlFotoCerveja = this.template({nomeFoto: resposta.nome});
		this.containerFotoCerveja.append(htmlFotoCerveja);
		
		//agora vem a parte para remover a foto
		$('.js-remove-foto').on('click', onRemoverFoto.bind(this));
	}
	
	function onRemoverFoto() {
		$('.js-foto-cerveja').remove();
		this.uploadDrop.removeClass('hidden');
		this.inputNomeFoto.val('');
		this.inputContentType.val('');
	}
	
	return UploadFoto; // o retorno da função BeeBee.UploadFoto = (function() {
	
})(); // o "();" executa a função - BeeBee.UploadFoto


$(function() { // aqui é onde fazemos acontecer!!!
	
	var uploadFoto = new BeeBee.UploadFoto();
	uploadFoto.iniciar();
});
