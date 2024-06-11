package com.gbLisboa.produtoService.repository;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gbLisboa.produtoService.dominio.Produto;

@Repository
public interface IProdutoRepository extends MongoRepository<Produto, String> {
	Optional<Produto> findByCodigo(Long Codigo);
}
