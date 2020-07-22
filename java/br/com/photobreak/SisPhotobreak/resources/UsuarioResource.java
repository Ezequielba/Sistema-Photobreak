package br.com.photobreak.SisPhotobreak.resources;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import br.com.photobreak.SisPhotobreak.entities.Usuario;
import br.com.photobreak.SisPhotobreak.services.UsuarioService;

@Controller
@SessionAttributes
public class UsuarioResource {
	
	boolean loginValido = false;
	
	@Autowired
	private UsuarioService service;
	

	@GetMapping(value = {"/","/login"})
	public String home(Model model){
		loginValido = false;
		 model.addAttribute("user", new Usuario());
		return "login";
	}
	
	@PostMapping(value = "/login")
	public String home(HttpServletRequest request, 
	        @RequestParam(value="email", required=false) String email, 
	        @RequestParam(value="senha", required=false) String senha
	        ){
		if(service.usuarioValido(email, senha)) {
			loginValido = true;
			 return "redirect:/principal";
		 }
		 return "login";
	}
	
	@GetMapping({"/principal"})
	public String List(){
		 if(loginValido) {
			 return "/principal";
			 }
		return "redirect:/usuarios";
	}
	
	@GetMapping({"/usuarios"})
	public String List(Model model){
		 model.addAttribute("login", service.findAll());
		 if(loginValido) {
			 return "/usuarios";
			 }
		return "redirect:/login";
	}
	
	@GetMapping({"/editarusuario"})
	public String editar(Long id, Model model, HttpServletRequest request){
		System.out.print("Teste: " + id );
		id = Long.parseLong(request.getParameter("id"));
		 model.addAttribute("usuario", service.findById(id));
		return "/editarusuario";
	}
	
	@PostMapping(value="/editarusuario")
	public String editar(HttpServletRequest request, 
			@RequestParam(value="id", required=false) Long id,
	        @RequestParam(value="nome", required=false) String nome, 
	        @RequestParam(value="telefone", required=false) String telefone,
	        @RequestParam(value="email", required=false) String email,
	        @RequestParam(value="senha", required=false) String senha
	        ){
		Usuario usuario = new Usuario(null, nome, telefone, email, senha);
		service.update(id, usuario);
		return"redirect:/usuarios";
	}
	
	
	@RequestMapping({"/cadusuario"})
	public String Lista(){
		//model.addAttribute("produto", produto.findAll());
			 return "cadusuario";
	}
	
	@PostMapping(value="/cadusuario")
	public String insert(HttpServletRequest request, 
	        @RequestParam(value="nome", required=false) String nome, 
	        @RequestParam(value="telefone", required=false) String telefone,
	        @RequestParam(value="email", required=false) String email,
	        @RequestParam(value="senha", required=false) String senha
	        ){
		System.out.println(nome);
		Usuario usuario = new Usuario(null, nome, telefone, email, senha);
		service.insert(usuario);
		
		System.out.println(usuario.getNome());
		return"redirect:/usuarios";
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

	@GetMapping(value="/excluir")
	public String delete(Long id, HttpServletRequest request){
		id = Long.parseLong(request.getParameter("id"));
		service.detele(id);
		return "redirect:/usuarios";
	}

	@PutMapping(value="/{id}")
	public String update(@PathVariable Long id, @RequestBody Usuario obj){
		obj = service.update(id, obj);
		return "redirect:/usuarios";
	}

}
