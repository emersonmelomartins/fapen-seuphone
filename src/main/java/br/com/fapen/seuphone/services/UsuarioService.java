package br.com.fapen.seuphone.services;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fapen.seuphone.forms.UsuarioForm;
import br.com.fapen.seuphone.models.Perfil;
import br.com.fapen.seuphone.models.Usuario;
import br.com.fapen.seuphone.repositories.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRep;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		Usuario usuarioEncontrado = usuarioRep.findByLogin(login);
		
		return usuarioEncontrado;
	}
	
	public void salvar(UsuarioForm usuarioForm) {
		if(usuarioForm.isInclusao()) {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String senhaCripto = encoder.encode(usuarioForm.getUsuario().getPassword());
			usuarioForm.getUsuario().setSenha(senhaCripto);
		}
		
		usuarioForm.getUsuario().getAuthorities().clear();
		for(Perfil perfil: usuarioForm.getListaPerfil()) {
			if(perfil.getAuthority() != null) {
				usuarioForm.getUsuario().getAuthorities().add(perfil);
			}
		}
		
		usuarioRep.save(usuarioForm.getUsuario());
	}
	
	public String gerarHash(String email) {
		Usuario usuario = usuarioRep.findByEmail(email);
		
		String dadosUsuario = usuario.getLogin() + usuario.getEmail() + usuario.getSenha();
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch(NoSuchAlgorithmException e) {
			throw new RuntimeException();
		}
		
		BigInteger hash = new BigInteger(1, md.digest(dadosUsuario.getBytes()));
		return hash.toString(16);
	}
	
	public void alterarSenha(String senha, Long id) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String senhaCripto = encoder.encode(senha);
		
		usuarioRep.alterarSenha(senhaCripto, id);
		usuarioRep.alterarHash(null, id);
	}
	
	
}
