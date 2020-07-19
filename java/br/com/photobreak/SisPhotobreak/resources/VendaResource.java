package br.com.photobreak.SisPhotobreak.resources;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.photobreak.SisPhotobreak.entities.Cliente;
import br.com.photobreak.SisPhotobreak.entities.Produto;
import br.com.photobreak.SisPhotobreak.entities.Venda;
import br.com.photobreak.SisPhotobreak.services.ProdutoService;
import br.com.photobreak.SisPhotobreak.services.VendaService;

@Controller
public class VendaResource {

	@Autowired
	private VendaService venda;
	
	@Autowired
	private ProdutoService produto;
	
	@Autowired
	private ProdutoService cliente;

	@RequestMapping({ "/venda" })
	public String Lista(Model model) {
		model.addAttribute("venda", venda.findAll());
		System.out.println("");
		System.out.println(venda.findAll());
		System.out.println("");
		System.out.println("");
		return "venda";
	}

	@RequestMapping({ "/cadvenda" })
	public String cadVenda(Model model) {
		 model.addAttribute("produto", produto.findAll());
		 model.addAttribute("cliente", cliente.findAll());
		return "cadvenda";
	}

	@PostMapping(value = "/cadvenda")
	public String insert(HttpServletRequest request, 
			@RequestParam(value = "cliente", required = false) String cliente,
			@RequestParam(value = "valorvenda", required = false) String valorvenda,
			@RequestParam(value = "produto", required = false) String produto,
			@RequestParam(value = "datavenda", required = false) String datavenda) {
		Cliente c1 = new Cliente();
		Produto p1 = new Produto();
		c1.setId(Long.parseLong(cliente));
		p1.setId(Long.parseLong(produto));
		//Venda vendas = new Venda(null, valorvenda, datavenda);
		Venda v1 = new Venda(null, "600,00", "01/05/2020", c1, p1);
		
		System.out.println("");
		System.out.print(cliente + " | " + valorvenda + " | " + produto + " | " + datavenda);
		System.out.println("");
		System.out.println("");
		
		venda.insert(v1);
		
		return "redirect:/venda";
	}

	@GetMapping(value = "/excluirvenda")
	public String delete(Long id, HttpServletRequest request) {
		id = Long.parseLong(request.getParameter("id"));
		venda.detele(id);
		return "redirect:/venda";
	}

	/*
	 * @GetMapping public ResponseEntity<List<Venda>> findAll() { List<Venda> list =
	 * service.findAll(); return ResponseEntity.ok().body(list); }
	 * 
	 * @GetMapping(value = "/{id}") public ResponseEntity<Venda>
	 * findById(@PathVariable Long id) { Venda obj = venda.findById(id); return
	 * ResponseEntity.ok().body(obj); }
	 * 
	 * @PostMapping public ResponseEntity<Venda> insert(@RequestBody Venda obj){ obj
	 * = service.insert(obj); URI uri =
	 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand
	 * (obj.getId()).toUri(); return ResponseEntity.created(uri).body(obj); }
	 */
}
