package br.com.fapen.seuphone.services;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class EmailService  {
	
	@Autowired
	private JavaMailSender sender;

	
	public void enviarEmailHtml(String destinatario, String assunto, String conteudo) {
		try {
			
			MimeMessage htmlMessage = sender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(htmlMessage, true);
			
			helper.setTo(destinatario);
			helper.setSubject(assunto);
			helper.setText(conteudo, true);
			
			File logo = new File("/home/emerson/Downloads/dev/media/logo.png");
			helper.addInline("logo-seuphone", logo);
			
			sender.send(htmlMessage);
			System.out.println("Email enviado com sucesso!");
		} catch(Exception e) {
			System.out.println("Erro no email --> " + e.getMessage());
		}
	}
}
