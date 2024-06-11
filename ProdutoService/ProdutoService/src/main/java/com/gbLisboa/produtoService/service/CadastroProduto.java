package com.gbLisboa.produtoService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gbLisboa.produtoService.dominio.Produto;
import com.gbLisboa.produtoService.repository.IProdutoRepository;

import jakarta.validation.Valid;

@Service
public class CadastroProduto {
	
	private IProdutoRepository produtoRepository;
	
	@Autowired
	public CadastroProduto(IProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	public Produto cadastrar (@Valid Produto produto) {
		return produtoRepository.insert(produto);
	}
	public Produto alterar(@Valid Produto produto) {
		return produtoRepository.save(produto);
	}
	public void remover (String id) {
		this.produtoRepository.deleteById(id);
	}
}
