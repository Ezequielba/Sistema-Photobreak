package br.com.photobreak.SisPhotobreak.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.photobreak.SisPhotobreak.entities.Cliente;
import br.com.photobreak.SisPhotobreak.services.ClienteService;

@Controller
public class ClienteResource {
	
	boolean loginValido = false;
	
	@Autowired
	private ClienteService cliente;

	@RequestMapping({"/cliente"})
	public String Lista(Model model){
		model.addAttribute("cliente", cliente.findAll());
			 return "cliente";
	}
	
	@RequestMapping({"/cadcliente"})
	public String Lista(){
		//model.addAttribute("produto", produto.findAll());
			 return "cadcliente";
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
		obj = cliente.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

}
