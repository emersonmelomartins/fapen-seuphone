package br.com.fapen.seuphone.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.fapen.seuphone.DTO.JwtRequestDTO;
import br.com.fapen.seuphone.DTO.JwtResponseDTO;
import br.com.fapen.seuphone.forms.UsuarioForm;
import br.com.fapen.seuphone.models.Produto;
import br.com.fapen.seuphone.models.Usuario;
import br.com.fapen.seuphone.services.ArquivoService;
import br.com.fapen.seuphone.services.JwtTokenService;
import br.com.fapen.seuphone.services.UsuarioService;
import br.com.fapen.seuphone.validations.UsuarioFormValidator;

@RestController
@RequestMapping(value = "/api/usuarios")
public class UsuarioApiController {
	
	@Autowired
    private UsuarioService usuarioService;

    @Autowired
    private JwtTokenService jwtTokenService;
    
    @Autowired
	private ArquivoService arquivoService;
    
	@Autowired
	private UsuarioFormValidator usuarioFormValidator;
	
	@InitBinder("usuarioForm")
	protected void init(WebDataBinder binder) {
		binder.setValidator(usuarioFormValidator);
	}

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @GetMapping
    public List<Usuario> listarTodos() {
    	return usuarioService.findAll();
    }

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequestDTO authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = usuarioService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenService.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponseDTO(token));
    }

    // Metodo que realiza a autenticacao no Spring Security
    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
    
    @PostMapping
	public ResponseEntity<Object> incluir(@Valid @RequestBody UsuarioForm usuarioForm, BindingResult resultadoValidacao) {

		if(resultadoValidacao.hasErrors()) {
			return new ResponseEntity<Object>(resultadoValidacao.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		if(usuarioForm.getUsuario().getCaminhoFoto() == "") {
			usuarioForm.getUsuario().setCaminhoFoto(null);
		}
    	usuarioService.salvar(usuarioForm);
		return new ResponseEntity<Object>(usuarioForm, HttpStatus.CREATED);
	}
    
    /*
    @PostMapping(value = "/avatarUpdate")
	public ResponseEntity<Object> alterarFotoPerfil() {
		
    	
		//String caminhoDaFoto = arquivoService.salvarArquivo(foto);
		
		//Usuario usuario = usuarioRep.findByLogin(principal.getName());
		//usuario.setCaminhoFoto(caminhoDaFoto);
		//usuarioRep.save(usuario);
		
		//Authentication authentication = new UsernamePasswordAuthenticationToken(usuario, usuario.getSenha(), usuario.getAuthorities());
		//SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return new ResponseEntity<Object>(base64Image, HttpStatus.ACCEPTED);
	}
	*/

}
