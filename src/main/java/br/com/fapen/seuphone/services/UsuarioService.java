package br.com.fapen.seuphone.services;

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
	
	
}
