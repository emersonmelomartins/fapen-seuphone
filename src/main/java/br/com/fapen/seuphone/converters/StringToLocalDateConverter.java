package br.com.fapen.seuphone.converters;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToLocalDateConverter implements Converter<String, LocalDate> {
	
	@Override
	public LocalDate convert(String source) {
		if(source.equals("")) {
			return null;
		}
		
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return LocalDate.parse(source, formatador);
	}
	
}

