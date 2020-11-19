package br.com.fapen.seuphone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import br.com.fapen.seuphone.filters.JwtAuthenticationEntryPoint;
import br.com.fapen.seuphone.filters.JwtRequestFilter;

@EnableWebSecurity
public class SeuphoneSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService usuarioService;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Order(1)
	@Configuration
	public static class ApiConfig extends WebSecurityConfigurerAdapter {

		@Autowired
		private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

		@Autowired
		private JwtRequestFilter jwtRequestFilter;

		@Override
		protected void configure(HttpSecurity http) throws Exception {

			http.cors().and().csrf().disable().antMatcher("/api/**").authorizeRequests().antMatchers("/api/usuarios/login")
					.permitAll().antMatchers("/api/usuarios/criarUsuario").permitAll()
					.antMatchers(HttpMethod.GET, "/api/produtos/**").permitAll().antMatchers(HttpMethod.POST, "/api/**")
					.authenticated().antMatchers(HttpMethod.POST, "/api/produtos/**").authenticated()
					.antMatchers(HttpMethod.POST, "/api/produtos").authenticated()
					.antMatchers(HttpMethod.POST, "/api/usuarios/**").authenticated()
					.antMatchers(HttpMethod.POST, "/api/usuarios").authenticated().anyRequest().authenticated().and()
					.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable();

			http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		}

	}

	@Order(2)
	@Configuration
	public static class WebConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().antMatchers("/api/**").permitAll().antMatchers("/").permitAll().antMatchers("/home")
					.permitAll().antMatchers("/error").permitAll().antMatchers("/js/**").permitAll().antMatchers("/css/**")
					.permitAll().antMatchers("/img/**").permitAll().antMatchers("/esqueci-senha").permitAll()
					.antMatchers("/esqueci-senha/**").permitAll().antMatchers("/recuperar-senha").permitAll()
					.antMatchers("/recuperar-senha/**").permitAll().antMatchers(HttpMethod.POST, "/enviar-email").permitAll()
					.antMatchers(HttpMethod.POST, "/trocar-senha").permitAll().antMatchers("/usuarios/meuperfil").authenticated()
					.antMatchers("/usuarios/alterarFoto").authenticated().antMatchers("/usuarios/**").hasRole("ADMIN")
					.antMatchers("/perfis/**").hasRole("ADMIN").antMatchers("/produtos/**/excluir").hasRole("ADMIN")
					.antMatchers("/fornecedores/**/excluir").hasRole("ADMIN").antMatchers("/pedidos/**/excluir").hasRole("ADMIN")
					.anyRequest().authenticated().and().formLogin().loginPage("/login").defaultSuccessUrl("/painel").permitAll()
					.and().csrf().disable().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
					.logoutSuccessUrl("/");
		}
	}

}
