package br.com.fapen.seuphone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@SpringBootApplication
public class SeuphoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeuphoneApplication.class, args);
	}
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource bundle = new ReloadableResourceBundleMessageSource();
		bundle.setBasename("classpath:messages");
		bundle.setDefaultEncoding("UTF-8");
		bundle.setCacheSeconds(1);
		
		return bundle;
	}

}
