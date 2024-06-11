package com.gbLisboa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gbLisboa.dominio.Cliente;
import com.gbLisboa.exception.EntityNotFoundException;
import com.gbLisboa.repository.IClienteRepository;

@Service
public class BuscarCliente {

	private IClienteRepository clienteRepository;//propriedade da interface onde nela chamamos os metodos para fazer a busca
	
	@Autowired //annotation para instancia-lo automaticamente no momento que eu chamar essa propriedade.
	public BuscarCliente(IClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository; //nesse construtor ele determina que a propriedade que não foi instanciada anteriormente, será a partir do momento que for chamado (propriedade).
	}
	
	public Page<Cliente> buscar (Pageable pageable){
		return clienteRepository.findAll(pageable);
	}
	
	public Cliente buscarPorId(String id) {
		return clienteRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(Cliente.class, "id", id));
	}
	
	public Boolean isCadastrado(String id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.isPresent() ? true : false;
	}
	
	public Cliente buscarPorCpf(Long cpf) {
		return clienteRepository.findByCpf(cpf)
				.orElseThrow(() -> new EntityNotFoundException(Cliente.class, "cpf", String.valueOf(cpf)));
	}
}
