package br.com.photobreak.SisPhotobreak.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.photobreak.SisPhotobreak.entities.Usuario;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioResource {
	
	@GetMapping
	public ResponseEntity<Usuario> findAll() {
		Usuario u = new Usuario(1L, "Ezequiel", "999999", "ezequiel@gmail.com", "123456");
		return ResponseEntity.ok().body(u);
	}

}
