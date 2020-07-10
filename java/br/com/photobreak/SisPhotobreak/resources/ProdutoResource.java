package br.com.photobreak.SisPhotobreak.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.photobreak.SisPhotobreak.services.ProdutoService;

@Controller
public class ProdutoResource {
	
	@Autowired
	private ProdutoService produto;
	
	@RequestMapping({"/produto"})
	public String Lista(Model model){
		model.addAttribute("produto", produto.findAll());
			 return "produto";
	}
	
	@RequestMapping({"/cadproduto"})
	public String Lista(){
		//model.addAttribute("produto", produto.findAll());
			 return "cadproduto";
	}
	


/*
	@GetMapping
	public ResponseEntity<List<Produto>> findAll() {
		List<Produto> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id){
		Produto obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping
	public ResponseEntity<Produto> insert(@RequestBody Produto obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
*/
}
