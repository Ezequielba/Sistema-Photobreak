package br.com.photobreak.SisPhotobreak.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.photobreak.SisPhotobreak.entities.Cliente;
import br.com.photobreak.SisPhotobreak.entities.Parcela;
import br.com.photobreak.SisPhotobreak.entities.Produto;
import br.com.photobreak.SisPhotobreak.entities.Usuario;
import br.com.photobreak.SisPhotobreak.entities.Venda;
import br.com.photobreak.SisPhotobreak.repositories.ClienteRepository;
import br.com.photobreak.SisPhotobreak.repositories.ParcelaRepository;
import br.com.photobreak.SisPhotobreak.repositories.ProdutoRepository;
import br.com.photobreak.SisPhotobreak.repositories.UsuarioRepository;
import br.com.photobreak.SisPhotobreak.repositories.VendaRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	private ParcelaRepository parcelaRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Suellen Brito", "011 92746-2836", "suellen@gmail.com", "223344");
		Usuario u2 = new Usuario(null, "Ezequiel Brito", "011 92736-3837", "ezequiel@gmail.com", "123456");
		
		Cliente c1 = new Cliente(null, "Eliel", "011 98363-2726", "eliel@gmail.com", "Rua confissão", "Monte Castelo", "Mauá", "09587-230", "01/05/2022");
		Cliente c2 = new Cliente(null, "Cleusa", "011 93647-2354", "cleusa@gmail.com", "Rua barão", "Monte Castelo", "Mauá", "09587-230", "15/03/2023");
		Cliente c3 = new Cliente(null, "João", "011 93647-2354", "XXXXXX@gmail.com", "Rua barão", "Monte Castelo", "Mauá", "09587-230", "08/10/2022");
		Cliente c4 = new Cliente(null, "Isadora", "011 93647-2354", "YYYYYY@gmail.com", "Rua barão", "Monte Castelo", "Mauá", "09587-230", "15/05/2022");
		Cliente c5 = new Cliente(null, "Carlos", "011 93647-2354", "ZZZZZZ@gmail.com", "Rua barão", "Monte Castelo", "Mauá", "09587-230", "04/08/2022");
		
		Produto p1 = new Produto(null, "Cabine de Fotos", "1200.00");
		Produto p2 = new Produto(null, "Totem de fotos", "1100.00");
		Produto p3 = new Produto(null, "Espelho de fotos", "1500.00");
		Produto p4 = new Produto(null, "Lambe-Lambe", "1400.00");
		
		Venda v1 = new Venda(null, "600,00", "01/05/2020", c1, p2);
		Venda v2 = new Venda(null, "380,00", "10/02/2018", c2, p1);
		
		Parcela pa1 = new Parcela(null, "1/10", 100.00, 0.0, "10/02/2018", 0.0, 0.0, "10/02/2018", 900.00, c1, v2, p2);
		
		usuarioRepository.saveAll(Arrays.asList(u1, u2));
		clienteRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3, p4));
		
		vendaRepository.saveAll(Arrays.asList(v1));
		vendaRepository.saveAll(Arrays.asList(v2));
		//vendaRepository.saveAll(Arrays.asList(v3));
		parcelaRepository.saveAll(Arrays.asList(pa1));
		
		System.out.println();
		System.out.println("### PROGRAMA INICIADO COM SUCESSO!!! ###");

	}
}
