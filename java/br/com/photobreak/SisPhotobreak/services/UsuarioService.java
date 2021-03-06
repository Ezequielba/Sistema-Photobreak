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
	
	public Usuario update(Long id, Usuario obj) {
		Usuario entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(Usuario entity, Usuario obj) {
		entity.setNome(obj.getNome());;
		entity.setEmail(obj.getEmail());
		entity.setTelefone(obj.getTelefone());
		entity.setSenha(obj.getSenha());
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
