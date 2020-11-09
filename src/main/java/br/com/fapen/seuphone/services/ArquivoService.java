package br.com.fapen.seuphone.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ArquivoService {

	// Necessário alterar caminho das imagens salvas caso esteja em uma máquina diferente
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
	
	public String ImageToString(String caminhoFoto) throws IOException {
		File f = new File("/home/emerson/Downloads/dev/" + caminhoFoto);
		FileInputStream fis = new FileInputStream(f);
		
		byte[] bytes = new byte[(int)f.length()];
		
		fis.read(bytes);
		
		String imgEncoded = new String(Base64.encodeBase64(bytes), "UTF-8");
		
		return imgEncoded;
	}
	
	public String saveBase64Image(String base64Image) throws IOException {
		    byte imageBytes[] = Base64.decodeBase64(base64Image);
		    String caminhoFisico = DIRETORIO_BASE;
		    
		    File diretorio = new File(caminhoFisico);
		    if(!diretorio.exists()) {
		    	diretorio.mkdir();
		    }
		    diretorio = null;
		    
			
		
			try {
				File file = new File(caminhoFisico + System.currentTimeMillis()+"_profile.png");
				
				FileOutputStream fos = new FileOutputStream(file); 
				fos.write(imageBytes);
				fos.close();
				return "media/" + file.getName();
			} catch (IllegalStateException e) {
				System.out.println("Ocorreu um erro! --> " + e.getMessage());
				return "";
			}
		    
		    
			
		}
}
