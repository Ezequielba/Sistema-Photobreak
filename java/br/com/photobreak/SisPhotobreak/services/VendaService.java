package br.com.photobreak.SisPhotobreak.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.photobreak.SisPhotobreak.entities.Venda;
import br.com.photobreak.SisPhotobreak.repositories.VendaRepository;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository repository;
	
	public List<Venda> findAll(){
		return repository.findAll();
	}
	
	public Venda findById(Long id){
		Optional<Venda> obj = repository.findById(id);
		return obj.get();
	}
	
	public Venda insert(Venda obj) {
		return repository.save(obj);
	}
	
	public void detele(Long id) {
		repository.deleteById(id);
	}
	
	public Venda update(Long id, Venda obj) {
		Venda entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(Venda entity, Venda obj) {
		entity.setValorVenda(obj.getValorVenda());
		entity.setDataVenda(obj.getDataVenda());
		entity.setCliente(obj.getCliente());
		entity.setProduto(obj.getProduto());
	}
}
