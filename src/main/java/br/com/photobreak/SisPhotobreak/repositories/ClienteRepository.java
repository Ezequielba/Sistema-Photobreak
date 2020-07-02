package br.com.photobreak.SisPhotobreak.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.photobreak.SisPhotobreak.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
