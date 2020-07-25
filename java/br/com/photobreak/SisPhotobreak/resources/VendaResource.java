package br.com.photobreak.SisPhotobreak.resources;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.photobreak.SisPhotobreak.entities.Cliente;
import br.com.photobreak.SisPhotobreak.entities.Produto;
import br.com.photobreak.SisPhotobreak.entities.Venda;
import br.com.photobreak.SisPhotobreak.services.ClienteService;
import br.com.photobreak.SisPhotobreak.services.ProdutoService;
import br.com.photobreak.SisPhotobreak.services.VendaService;

@Controller
public class VendaResource {

	@Autowired
	private VendaService venda;

	@Autowired
	private ProdutoService produto;

	@Autowired
	private ClienteService cliente;
	
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
	
	@GetMapping(value = "/listaClientes")
	public ResponseEntity<List<Cliente>> findAll() {
		List<Cliente> list = cliente.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	
	@GetMapping({"/editarvenda"})
	public String editar(Long id, Model model, HttpServletRequest request){
		id = Long.parseLong(request.getParameter("id"));
		 model.addAttribute("venda", venda.findById(id));	 
		 model.addAttribute("produto", produto.findAll());
		 model.addAttribute("cliente", cliente.findAll());
		return "/editarvenda";
	}
	
	@PostMapping(value="/editarvenda")
	public String editar(HttpServletRequest request, 
			@RequestParam(value="id", required=false) Long id,
	        @RequestParam(value="valorvenda", required=false) String valorvenda, 
	        @RequestParam(value="datavenda", required=false) String datavenda,
	        @RequestParam(value="produto", required=false) String produto,
	        @RequestParam(value="cliente", required=false) String cliente
	        ){

		System.out.println("");
		System.out.println("");
		System.out.print("Primeiro: " + valorvenda + " | " + datavenda + " | " + cliente + " | " + produto);
		System.out.println("");
		System.out.println("");
		
		Cliente c1 = new Cliente();
		Produto p1 = new Produto();
		c1.setId(Long.parseLong(cliente));
		p1.setId(Long.parseLong(produto));
		
		System.out.println("");
		System.out.println("");
		System.out.print("Segundo: " + valorvenda + " | " + datavenda + " | " + c1 + " | " + p1);
		System.out.println("");
		System.out.println("");
		
		Venda v1 = new Venda(null, valorvenda, datavenda, c1, p1);
		
		venda.update(id, v1);
		return"redirect:/venda";
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
		Venda v1 = new Venda(null, valorvenda, datavenda, c1, p1);
		
		System.out.println("");
		System.out.print(cliente + " | " + valorvenda + " | " + produto + " | " + datavenda + " | " + c1 + " | " + p1);
		System.out.println("");
		System.out.println("");

		venda.insert(v1);

		//Convertendo String para long
		long val = Long.valueOf(v1.getId());
		
		System.out.println("");
		System.out.println("");
		System.out.print("Pegando ID String: " + v1.getId() + " - Convertendo para long: " + val);
		System.out.println("");
		System.out.println("");
		
		//Parcela não está deixando inserir o ID da venda com val ou v1.getID:
		//Parcela pa2 = new Parcela(null, "1/10", 100.00, 0.0, "10/02/2018", 0.0, 0.0, "10/02/2018", 900.00, cliente, val, produto);
		//parcela.insert(pa2);
		
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
