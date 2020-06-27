package br.com.photobreak.SisPhotobreak.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.photobreak.SisPhotobreak.entities.Usuario;
import br.com.photobreak.SisPhotobreak.repositories.UsuarioRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Maria Brown", "999999999", "maria@gmail.com", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "888888888", "alex@gmail.com", "123456"); 
		
		usuarioRepository.saveAll(Arrays.asList(u1, u2));
	}
	
	
}
