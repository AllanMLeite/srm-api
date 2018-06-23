package com.srm.api.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.srm.api.model.Cliente;
import com.srm.api.model.dto.ClienteDto;
import com.srm.api.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente salvar(ClienteDto clienteDto) {
		Cliente cliente = new Cliente(clienteDto);
		return clienteRepository.save(cliente);
	}

	public ArrayList<Cliente> listar() {
		return (ArrayList<Cliente>) clienteRepository.findAll();
	}

	public Cliente consultar(Long idCliente) {
		return clienteRepository.findById(idCliente).orElse(null);
	}
}