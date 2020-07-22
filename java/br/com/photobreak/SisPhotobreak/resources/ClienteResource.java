package br.com.photobreak.SisPhotobreak.resources;

import java.net.URI;
import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.photobreak.SisPhotobreak.entities.Cliente;
import br.com.photobreak.SisPhotobreak.services.ClienteService;

@Controller
public class ClienteResource {
	
	boolean loginValido = true;
	
	@Autowired
	private ClienteService service;

	@RequestMapping({"/cliente"})
	public String Lista(Model model){
		model.addAttribute("cliente", service.findAll());
		 if(loginValido) {
			 return "cliente";
			 }
		return "redirect:/login";
	}
	
	@RequestMapping({"/cadcliente"})
	public String Lista(){
		//model.addAttribute("produto", produto.findAll());
			 return "cadcliente";
	}
	
	@PostMapping(value="/cadcliente")
	public String insert(HttpServletRequest request, 
	        @RequestParam(value="nome", required=false) String nome, 
	        @RequestParam(value="telefone", required=false) String telefone,
	        @RequestParam(value="email", required=false) String email,
	        @RequestParam(value="enderecocliente", required=false) String enderecocliente,
	        @RequestParam(value="enderecoevento", required=false) String enderecoevento,
	        @RequestParam(value="cidade", required=false) String cidade,
	        @RequestParam(value="cep", required=false) String cep,
	        @RequestParam(value="dataevento", required=false) String dataevento
	        ){
		Cliente clientes = new Cliente(null, nome, telefone, email, enderecocliente, enderecoevento, cidade, cep, dataevento);
		service.insert(clientes);
		return"redirect:/cliente";
	}
	
	@GetMapping(value="/excluircli")
	public String delete(Long id, HttpServletRequest request){
		id = Long.parseLong(request.getParameter("id"));
		System.out.println(id);
		service.detele(id);
		return "redirect:/cliente";
	}
	
	
	@GetMapping({"/editarcliente"})
	public String editar(Long id, Model model, HttpServletRequest request){
		id = Long.parseLong(request.getParameter("id"));
		 model.addAttribute("cliente", service.findById(id));
		return "/editarcliente";
	}
	
	@PostMapping(value="/editarcliente")
	public String editar(HttpServletRequest request, 
			@RequestParam(value="id", required=false) Long id,
	        @RequestParam(value="nome", required=false) String nome, 
	        @RequestParam(value="telefone", required=false) String telefone,
	        @RequestParam(value="email", required=false) String email,
	        @RequestParam(value="enderecocliente", required=false) String enderecocliente,
	        @RequestParam(value="enderecoevento", required=false) String enderecoevento,
	        @RequestParam(value="cidade", required=false) String cidade,
	        @RequestParam(value="cep", required=false) String cep,
	        @RequestParam(value="dataevento", required=false) String dataevento
	        ){
		Cliente cliente = new Cliente(null, nome, telefone, email, enderecocliente, enderecoevento, cidade, cep, dataevento);		
		service.update(id, cliente);
		return"redirect:/cliente";
	}

/*	@GetMapping
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Cliente> findById(@PathVariable Long id){
		Cliente obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
*/	
	@PostMapping
	public ResponseEntity<Cliente> insert(@RequestBody Cliente obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

}
