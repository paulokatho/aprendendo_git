package com.dbServer.tratoFeito.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dbServer.tratoFeito.model.RestauranteEnum;
import com.dbServer.tratoFeito.model.UsuarioEnum;
import com.dbServer.tratoFeito.model.Votacao;

@Controller
public class VotacoesController {

	/***
	 * Caso fosse salvar no banco poderia ser utilizado injeção de independencia para as classes de serviço e repositorio
	 * 
	 
	
	@Autowired
	private Restaurantes restaurantes;
	
	@Autowired
	private Usuarios usuarios;
	
	@Autowired
	private CadastroVotacaoService cadastroVotacaoService;
	
	*/
	
	@RequestMapping("/votacoes/novo")
	public ModelAndView novo(Votacao votacao) {
		
		ModelAndView mv = new ModelAndView("votacao/CadastroVotacao");
		
		//*** aqui estou setando o valor dos enumeradores de restaurante e usuarios
		mv.addObject("restaurantes", RestauranteEnum.values());
		mv.addObject("usuarios", UsuarioEnum.values());
		
		//*** Se fosse para setar o valor nos popups na tela html da votacao
		//*** e o findaAll() é porque esta retornando uma lista de uma pesquisa no banco na tabela estilo
			//mv.addObject("restaurantes", restaurantes.findAll());
				
		return mv;
	}
	
	@RequestMapping(value = "/votacoes/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Votacao votacao, BindingResult result, Model model, RedirectAttributes attributes) {
		
		if (result.hasErrors()) {
			return novo(votacao);
		}
		
		/***
		 * 	AQUI VEM A IMPLEMENTAÇÃO PARA ARMAZENAR E ESCOLHER O RESTAURANTE, PORÉM O CORRETO É SEPARAR A CLASSE DE SERVIÇO
		 * 		PARA QUE ELE EXECUTE ESSAS TAREFAS. AQUI FICA SOMENTE O CONTROLER PARA O DIRECIONAMENTO DAS REQUEST/RESPONSE.
		 */
		//cadastroVotacaoService.salvar(votacao);
		//attributes.addFlashAttribute("mensagem", "Voto salvo com sucesso!");		
		
		attributes.addFlashAttribute("mensagem", "O Restaurante escolhido é: " + votacao.getRestaurante().getDescricao());
		return new ModelAndView("redirect:/votacoes/novo");
	}
}
