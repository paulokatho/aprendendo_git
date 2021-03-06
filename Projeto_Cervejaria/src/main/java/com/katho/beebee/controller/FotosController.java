package com.katho.beebee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import com.katho.beebee.dto.FotoDTO;
import com.katho.beebee.storage.FotoStorage;
import com.katho.beebee.storage.FotoStorageRunnable;

@RestController
@RequestMapping("/fotos")
public class FotosController {
	
	@Autowired
	private FotoStorage fotoStorage;
	
	//@RequestMapping(method = RequestMethod.POST) *** A assinatura abaixo substitui essa.
	@PostMapping /* Esse @PostMapping somente a partir do Spring 4.3 */	
	public DeferredResult<FotoDTO> upload(@RequestParam("files[]") MultipartFile[] files) { //aqui vamos receber varios tipos de arquivo (jpg,png...) então definir Mult...
		
		DeferredResult<FotoDTO> resultado = new DeferredResult<>();
		
		//criando uma nova thread para devolver a resposta do servidor
		Thread thread = new Thread(new FotoStorageRunnable(files, resultado, fotoStorage));
		thread.start();
		
		return resultado;
	}
}
