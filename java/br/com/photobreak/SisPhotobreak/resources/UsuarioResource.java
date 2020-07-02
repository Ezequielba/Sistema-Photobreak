package br.com.photobreak.SisPhotobreak.resources;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.photobreak.SisPhotobreak.entities.Usuario;
import br.com.photobreak.SisPhotobreak.services.UsuarioService;

@Controller
@SessionAttributes
public class UsuarioResource {
	
	boolean loginValido = false;
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping(value = {"/","/usuarios"})
	public String home(Model model){
		 model.addAttribute("user", new Usuario());
		return "usuarios";
	}
	
	@PostMapping(value = "/usuarios")
	public String home(HttpServletRequest request, 
	        @RequestParam(value="email", required=false) String email, 
	        @RequestParam(value="senha", required=false) String senha
	        ){
		if(service.usuarioValido(email, senha)) {
			loginValido = true;
			 return "redirect:/principal";
		 }
		 return "usuarios";
	}
	
	@GetMapping({"/principal"})
	public String List(Model model){
		 model.addAttribute("login", service.findAll());
		 if(loginValido) {
			 loginValido = false;
			 return "/principal";
			 }
		return "redirect:/usuarios";
	}
	
	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id){
		Usuario obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> insert(@RequestBody Usuario obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
}
