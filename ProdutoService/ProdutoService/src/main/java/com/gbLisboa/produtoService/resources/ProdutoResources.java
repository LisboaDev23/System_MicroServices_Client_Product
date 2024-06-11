package com.gbLisboa.produtoService.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gbLisboa.produtoService.dominio.Produto;
import com.gbLisboa.produtoService.service.BuscarProduto;
import com.gbLisboa.produtoService.service.CadastroProduto;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoResources {
	
	private BuscarProduto buscarProduto;
	private CadastroProduto cadastroProduto;
	
	@Autowired
	public ProdutoResources(BuscarProduto buscarProduto, 
			CadastroProduto cadastroProduto ) {
		this.buscarProduto = buscarProduto;
		this.cadastroProduto = cadastroProduto;
	}
	@GetMapping
	public ResponseEntity<Page<Produto>> buscar(Pageable pageable){
		return ResponseEntity.ok(buscarProduto.buscar(pageable));
	}
	@GetMapping(value = "/{id}")
	@Operation(summary = "Busca um produto pelo id")
	public ResponseEntity<Produto>buscarPorId(@PathVariable(value = "id",required = true)String id){
		return ResponseEntity.ok(buscarProduto.buscarPorId(id));
	}
	
	@GetMapping(value = "isCadastrado/{id}")
	public ResponseEntity<Boolean> isCadastrado(@PathVariable(value = "id", required = true) String id) {
		return ResponseEntity.ok(buscarProduto.isCadastrado(id));
	}
	@PostMapping
	public ResponseEntity<Produto> cadastar(@RequestBody @Valid Produto produto) {
		return ResponseEntity.ok(cadastroProduto.cadastrar(produto));
	}
	@GetMapping(value = "/codigo/{codigp}")
	@Operation(summary = "Busca um produto pelo codigo")
	public ResponseEntity<Produto> buscarPorCodigo(@PathVariable(value = "codigo", required = true) Long codigo) {
		return ResponseEntity.ok(buscarProduto.buscarPorCodigo(codigo));
	}
	@PutMapping
	@Operation(summary = "Altera um produto")
	public ResponseEntity<Produto> alterar(@RequestBody @Valid Produto produto) {
		return ResponseEntity.ok(cadastroProduto.alterar(produto));
	}
	@DeleteMapping(value = "/{id}")
	@Operation(summary = "Remove um produto pelo seu identificador único")
	public ResponseEntity<String> remover(@PathVariable(value = "id") String id) {
		cadastroProduto.remover(id);
		return ResponseEntity.ok("Produto removido com sucesso");
	}
}
