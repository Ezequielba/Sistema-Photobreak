package br.com.photobreak.SisPhotobreak.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.photobreak.SisPhotobreak.entities.Produto;
import br.com.photobreak.SisPhotobreak.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repository;
	
	public List<Produto> findAll(){
		return repository.findAll();
	}
	
	public Produto findById(Long id){
		Optional<Produto> obj = repository.findById(id);
		return obj.get();
	}
	
	public Produto insert(Produto obj) {
		return repository.save(obj);
	}
	
	public void detele(Long id) {
		repository.deleteById(id);
	}
}
