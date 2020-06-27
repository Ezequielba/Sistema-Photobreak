package br.com.photobreak.SisPhotobreak.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.photobreak.SisPhotobreak.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
