package br.com.fapen.seuphone;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.fapen.seuphone.services.ArquivoService;

@Configuration
public class SeuphoneArquivoConfig implements WebMvcConfigurer {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/media/**").addResourceLocations("file://" + ArquivoService.DIRETORIO_BASE);
	}
}
