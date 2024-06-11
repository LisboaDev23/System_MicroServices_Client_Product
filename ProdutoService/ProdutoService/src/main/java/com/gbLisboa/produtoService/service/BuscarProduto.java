package com.gbLisboa.produtoService.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gbLisboa.produtoService.dominio.Produto;
import com.gbLisboa.produtoService.exception.EntityNotFoundException;
import com.gbLisboa.produtoService.repository.IProdutoRepository;

@Service
public class BuscarProduto {
	
	private IProdutoRepository produtoRepository;
	@Autowired
	public BuscarProduto(IProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public Page<Produto> buscar (Pageable pageable){
		return produtoRepository.findAll(pageable);
	}
	
	public Produto buscarPorId(String id) {
		return produtoRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(Produto.class, "id",id));
	}//metodo buscarPorId ele retorna um metodo do produtoRepository onde o próprio SpringBoot já cria automaticamente de achar por id
	//caso ele não encontre, ele joga uma exception onde diz que não encontrou a entidade
	public Boolean isCadastrado(String id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		return produto.isPresent() ? true : false;
	}
	public Produto buscarPorCodigo(Long codigo) {
		return produtoRepository.findByCodigo(codigo).orElseThrow(() -> new EntityNotFoundException(Produto.class,"codigo",String.valueOf(codigo)));
	}
	
	
}
