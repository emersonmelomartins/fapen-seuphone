package br.com.fapen.seuphone.services;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ArquivoService {

	public static final String DIRETORIO_BASE = "/home/emerson/Downloads/dev/media/";
	
	public String salvarArquivo(MultipartFile arquivo) {
		String caminhoFisico = DIRETORIO_BASE;
		
		File diretorio = new File(caminhoFisico);
		if(!diretorio.exists()) {
			diretorio.mkdir();
		}
		diretorio = null;
		
		String caminho = caminhoFisico + arquivo.getOriginalFilename();
		try {
			arquivo.transferTo(new File(caminho));
			return "media/" + arquivo.getOriginalFilename();
		} catch (IllegalStateException | IOException e) {
			System.out.println("Ocorreu um erro! --> " + e.getMessage());
			return "";
		}

	}
}
