package br.com.photobreak.SisPhotobreak.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.photobreak.SisPhotobreak.entities.Cliente;
import br.com.photobreak.SisPhotobreak.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> findAll(){
		return repository.findAll();
	}
	
	public void detele(Long id) {
		repository.deleteById(id);
	}
	
	public Cliente findById(Long id){
		Optional<Cliente> obj = repository.findById(id);
		return obj.get();
	}
	
	public Cliente insert(Cliente obj) {
		return repository.save(obj);
	}
	
	public Cliente update(Long id, Cliente obj) {
		Cliente entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(Cliente entity, Cliente obj) {
		entity.setNome(obj.getNome());;
		entity.setTelefone(obj.getTelefone());
		entity.setEmail(obj.getEmail());
		entity.setEnderecocliente(obj.getEnderecocliente());
		entity.setEnderecoevento(obj.getEnderecoevento());
		entity.setCidade(obj.getCidade());
		entity.setCep(obj.getCep());
		entity.setDataevento(obj.getDataevento());
	}
}
