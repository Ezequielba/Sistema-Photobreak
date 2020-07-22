package br.com.photobreak.SisPhotobreak.resources;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.photobreak.SisPhotobreak.entities.Produto;
import br.com.photobreak.SisPhotobreak.services.ProdutoService;

@Controller
public class ProdutoResource {
	
	@Autowired
	private ProdutoService service;
	
	@RequestMapping({"/produto"})
	public String Lista(Model model){
		model.addAttribute("produto", service.findAll());
			 return "produto";
	}
	
	@RequestMapping({"/cadproduto"})
	public String Lista(){
		//model.addAttribute("produto", produto.findAll());
			 return "cadproduto";
	}
	
	@PostMapping(value="/cadproduto")
	public String insert(HttpServletRequest request, 
	        @RequestParam(value="nome", required=false) String nome, 
	        @RequestParam(value="valor", required=false) String valor
	        ){
		Produto produtos = new Produto(null, nome, valor);
		service.insert(produtos);
		return"redirect:/produto";
	}
	
	@GetMapping({"/editarproduto"})
	public String editar(Long id, Model model, HttpServletRequest request){
		id = Long.parseLong(request.getParameter("id"));
		 model.addAttribute("produto", service.findById(id));
		return "/editarproduto";
	}
	
	@PostMapping(value="/editarproduto")
	public String editar(HttpServletRequest request, 
			@RequestParam(value="id", required=false) Long id,
	        @RequestParam(value="nome", required=false) String nome, 
	        @RequestParam(value="valor", required=false) String valor
	        ){
		Produto produto = new Produto(null, nome, valor);		
		service.update(id, produto);
		return"redirect:/produto";
	}
	
	
	@GetMapping(value="/excluirprod")
	public String delete(Long id, HttpServletRequest request){
		id = Long.parseLong(request.getParameter("id"));
		service.detele(id);
		return "redirect:/produto";
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
