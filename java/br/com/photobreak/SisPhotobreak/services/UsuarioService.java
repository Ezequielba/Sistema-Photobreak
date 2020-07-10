package br.com.photobreak.SisPhotobreak.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.photobreak.SisPhotobreak.entities.Usuario;
import br.com.photobreak.SisPhotobreak.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	public List<Usuario> findAll(){
		return repository.findAll();
	}
	
	public Usuario findById(Long id){
		Optional<Usuario> obj = repository.findById(id);
		return obj.get();
	}
	
	public Usuario insert(Usuario obj) {
		return repository.save(obj);
	}
	
	public void detele(Long id) {
		repository.deleteById(id);
	}
	
	public boolean usuarioValido(String email, String senha){
		List<Usuario> list = findAll();
		for (Usuario usuario : list) {
		     if(usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
		    	 return true;
		     }
		    }
		return false;
	}
}
