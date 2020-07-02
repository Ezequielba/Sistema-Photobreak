package br.com.photobreak.SisPhotobreak.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.photobreak.SisPhotobreak.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
