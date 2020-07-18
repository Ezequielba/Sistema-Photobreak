package br.com.photobreak.SisPhotobreak.resources;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.photobreak.SisPhotobreak.entities.Venda;
import br.com.photobreak.SisPhotobreak.services.VendaService;

@Controller
public class VendaResource {

	@Autowired
	private VendaService venda;

	@RequestMapping({ "/venda" })
	public String Lista(Model model) {
		model.addAttribute("venda", venda.findAll());
		return "venda";
	}

	@RequestMapping({ "/cadvenda" })
	public String Lista() {
		// model.addAttribute("produto", produto.findAll());
		return "cadvenda";
	}

	@PostMapping(value = "/cadvenda")
	public String insert(HttpServletRequest request, 
			@RequestParam(value = "cliente", required = false) String cliente,
			@RequestParam(value = "valorvenda", required = false) String valorvenda,
			@RequestParam(value = "produto", required = false) String produto,
			@RequestParam(value = "datavenda", required = false) String datavenda) {
		Venda vendas = new Venda(null, valorvenda, datavenda);
		System.out.print(valorvenda + datavenda);
		venda.insert(vendas);
		
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
