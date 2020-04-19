package br.com.fapen.seuphone.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity(name = "tb_pessoa")
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pessoa")
	private Long idPessoa;
	
	@Column(length = 100, nullable = false)
	private String nome;
	
	@Column(length = 11, nullable = false, unique = true)
	private String cpf;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "dt_nascimento", nullable = false)
	private LocalDate dtNascimento;
	
	@Column(length = 1, nullable = false)
	private String sexo;
	
	@Column(length = 11)
	private String celular;
	
	
	private String telefone;
	
}
