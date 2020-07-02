package br.com.photobreak.SisPhotobreak.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.photobreak.SisPhotobreak.entities.Venda;
import br.com.photobreak.SisPhotobreak.services.VendaService;

@RestController
@RequestMapping(value = "/vendas")
public class VendaResource {
	
	@Autowired
	private VendaService service;
	
	@GetMapping
	public ResponseEntity<List<Venda>> findAll() {
		List<Venda> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Venda> findById(@PathVariable Long id){
		Venda obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Venda> insert(@RequestBody Venda obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
}