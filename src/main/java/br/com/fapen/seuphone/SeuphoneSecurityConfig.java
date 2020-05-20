package br.com.fapen.seuphone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SeuphoneSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService usuarioService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioService).passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/home").permitAll()
		.antMatchers("/js/**").permitAll()
		.antMatchers("/css/**").permitAll()
		.antMatchers("/img/**").permitAll()
		.antMatchers("/esqueci-senha").permitAll()
		.antMatchers("/esqueci-senha/**").permitAll()
		.antMatchers("/recuperar-senha").permitAll()
		.antMatchers("/recuperar-senha/**").permitAll()
		.antMatchers(HttpMethod.POST, "/enviar-email").permitAll()
		.antMatchers(HttpMethod.POST, "/trocar-senha").permitAll()
		.antMatchers("/usuarios/**").hasRole("ADMIN")
		.antMatchers("/perfis/**").hasRole("ADMIN")
		.antMatchers("/produtos/**/excluir").hasRole("ADMIN")
		.antMatchers("/fornecedores/**/excluir").hasRole("ADMIN")
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login").defaultSuccessUrl("/painel").permitAll()
		.and()
		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/");
	}
}
