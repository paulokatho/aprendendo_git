package com.katho.beebee.storage.local;

import static java.nio.file.FileSystems.getDefault;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import com.katho.beebee.storage.FotoStorage;

public class FotoStorageLocal implements FotoStorage {

	private static final Logger logger = LoggerFactory.getLogger(FotoStorageLocal.class);
	
	private Path local;
	private Path localTemporario;
	
	public FotoStorageLocal() {
		// dentro de HOME vamos criar uma pasta beebeefotos e depois chamamos o método criarPastas()
		this(getDefault().getPath(System.getenv("USERPROFILE"), ".beebeefotos"));
		
	}
	
	
	public FotoStorageLocal(Path path) {
		
		this.local = path;
		criarPastas();
	}
	
	@Override
	public String salvarTemporariamente(MultipartFile[] files) {
		String novoNome = null;// a variavel foi implementada aqui, pois se estourar exception o catch consegue capturar
		if(files != null && files.length > 0) {
			MultipartFile arquivo = files[0];
			novoNome = renomearArquivo(arquivo.getOriginalFilename());
			try {
				arquivo.transferTo(new File(this.localTemporario.toAbsolutePath().toString() + getDefault().getSeparator() + novoNome));
			} catch (Exception e) {
				throw new RuntimeException("Erro salvando a foto na pasta temporária");
			}
		}
		return novoNome;
	}
	
	private void criarPastas() {
		// aqui pode lançar uma exception então vamos tratar
			
			try {
				Files.createDirectories(this.local);
				this.localTemporario = getDefault().getPath(this.local.toString(), "temp");
				Files.createDirectories(this.localTemporario);// vai criar no diretorio acima a pasta "temp"
				
				/*esse if vai criar no console do eclipse essas informações para que nós possamos mapear e verificar
					corretamente o que está acontecendo no sistema. Aqui quando subir a aplicação ele já vai criar as 
					pastas e mostrar no logo os paths
				*/
				if(logger.isDebugEnabled()) {
					logger.debug("Pastas criadas para salvar fotos.");
					logger.debug("Pasta default: " + this.local.toAbsolutePath());
					logger.debug("Pasta temporária: " + this.localTemporario.toAbsolutePath());
				}
			} catch (IOException e) {
				throw new RuntimeException("Erro criando pasta para salvar foto", e);
			}		
		}
	
	private String renomearArquivo(String nomeOriginal) {
		String novoNome = UUID.randomUUID().toString() + "_" + nomeOriginal;
		
		if(logger.isDebugEnabled()) { //habilitando o logger
			logger.debug(String.format("Nome original: %s, novo nome: %s", nomeOriginal, novoNome));
		}
		
		return novoNome;
	}
}
