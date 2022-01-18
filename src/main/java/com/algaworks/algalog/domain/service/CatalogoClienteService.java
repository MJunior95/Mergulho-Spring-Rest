package com.algaworks.algalog.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.algaworks.algalog.domain.exception.NegocioException;
import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CatalogoClienteService {

	private ClienteRepository repository;

	@Transactional
	public Cliente salvar(Cliente cliente) {

		boolean emailEmUso = repository.findByEmail(cliente.getEmail()).stream()
				.anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

		if (emailEmUso) {
			throw new NegocioException("Já existe um cliente cadastrado com este e-mail");
		}
		return repository.save(cliente);
	}

	@Transactional
	public void excluir(Long clienteId) {
		repository.deleteById(clienteId);
	}
	
	public Cliente buscar(Long clienteId) {
		return repository.findById(clienteId)
				.orElseThrow(() -> new NegocioException("Cliente não Encontrado"));
	}
}
