package br.com.photobreak.SisPhotobreak;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class SisPhotobreakApplication{	
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SisPhotobreakApplication.class);	
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SisPhotobreakApplication.class, args);
	}

}
