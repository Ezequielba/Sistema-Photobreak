package br.com.photobreak.SisPhotobreak.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.photobreak.SisPhotobreak.entities.Parcela;
import br.com.photobreak.SisPhotobreak.repositories.ParcelaRepository;

@Service
public class ParcelaService {
	
	@Autowired
	private ParcelaRepository repository;
	
	public List<Parcela> findAll(){
		return repository.findAll();
	}
	
	public Parcela findById(Long id){
		Optional<Parcela> obj = repository.findById(id);
		return obj.get();
	}
	
	public Parcela insert(Parcela obj) {
		return repository.save(obj);
	}
}
