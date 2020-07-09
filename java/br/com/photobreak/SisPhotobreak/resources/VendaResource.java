package br.com.photobreak.SisPhotobreak.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.photobreak.SisPhotobreak.services.VendaService;

@Controller
public class VendaResource {
	
	@Autowired
	private VendaService venda;
	
	@RequestMapping({"/venda"})
	public String Lista(Model model){
		model.addAttribute("venda", venda.findAll());
			 return "venda";
	}
	
/*	
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
*/	
}
