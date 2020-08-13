package br.com.photobreak.SisPhotobreak.resources;

import java.util.ArrayList;
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
import br.com.photobreak.SisPhotobreak.entities.Parcela;
import br.com.photobreak.SisPhotobreak.entities.Produto;
import br.com.photobreak.SisPhotobreak.entities.Venda;
import br.com.photobreak.SisPhotobreak.services.ClienteService;
import br.com.photobreak.SisPhotobreak.services.ParcelaService;
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
	
	@Autowired
	private ParcelaService parcelaService;
	
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
			@RequestParam(value = "datavenda", required = false) String datavenda,
			@RequestParam(value = "parcelamento", required = false) String parcelamento,
			@RequestParam(value = "vencimentoParcela", required = false) String vencimentoParcela,
			@RequestParam(value = "numParcela", required = false) String numParcela) {
		
		/*CRIEI ESSA VARIAVEL PARA RECEBER VALOR PENDENTE DA VENDA*/
		double valorPendente = Double.parseDouble(valorvenda);
		
		/*CRIEI ESSA LISTA PARA PEGAR TODOS OS VALORES DE PARCELA*/
		ArrayList<String> listParcelas = new ArrayList<String>();
		for(String item : parcelamento.split(",")){
			listParcelas.add(item);
		}
		
		/*CRIEI ESSA LISTA PARA PEGAR TODOS AS DATAS DE VENCIMENTO DAS PARCELAS*/
		ArrayList<String> listDataVencimento = new ArrayList<String>();
		for(String item : vencimentoParcela.split(",")){
			listDataVencimento.add(item);
		}
		
		/*CRIEI ESSE ARRAY BIDIMENCIONAL ONDE [VALOR DAS PARCELAS][VENCIMENTO DAS PARCELAS]*/
		String[][] parcelas = new String[Integer.parseInt(numParcela)][Integer.parseInt(numParcela)];
		/*FOR PARA ADICIONAR OS VALORES DAS LISTAS EM SEUS DEVIDOS LOCAIS*/
		for(int i = 0; i < Integer.parseInt(numParcela); i++) {
			parcelas[i][0] = listParcelas.toString().replace("[", " ").replace("]", " ").trim().split(",")[i];
			parcelas[i][1] = listDataVencimento.toString().replace("[", " ").replace("]", " ").trim().split(",")[i];
			}
		/*FIM DA PARTE 1*/
		
		Cliente c1 = new Cliente();
		Produto p1 = new Produto();
		c1.setId(Long.parseLong(cliente));
		p1.setId(Long.parseLong(produto));
		
		Venda v1 = new Venda(null, valorvenda, datavenda, c1, p1);
		venda.insert(v1);
		
		/*
		 * INICIO PARTE FINAL
		 * 
		 * FOR USADO PARA CRIAR AS PARCELAS NO BANCO DE DADOS 
		*/
		for(int i = 0; i < Integer.parseInt(numParcela); i++) {
		//CAUCULO ONDE VALOR PENDENTE RECEBE ELE MESMO MENOS O VALOR DA PARCELA
		valorPendente = valorPendente - Double.parseDouble(parcelas[i][0]);
		/*ADICIONANDO NUMERO DE PARELAS i+1+"/"+Integer.parseInt(numParcela)
		 * CONVERTENDO VALOR DA PARCELA Double.parseDouble(parcelas[i][0])
		 * GRAVANDO A DATA DE VENCIMENTO DA PARCELA E LIMPANDO OS ESPACO VAZIOS parcelas[i][1].trim()
		 * GRAVANDO DATA DA VENDA datavenda
		 * GRAVANDO VALOR PENDENTE valorPendente
		 */
		Parcela pa2 = new Parcela(null, i+1+"/"+Integer.parseInt(numParcela), Double.parseDouble(parcelas[i][0]), 0.0, parcelas[i][1].trim(), 0.0, 0.0, datavenda, valorPendente, c1, v1, p1);
		parcelaService.insert(pa2);
		}
		/*FIM DAS MUDANCAS NO METODO RESOURCE*/
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
