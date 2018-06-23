package com.srm.api.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientException;

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

	private void validarInclusao(Cliente cliente) {
		validaObrigatoriedadeNome(cliente);
		validaObrigatoriedadeRisco(cliente);
		validaObrigatoriedadeLimite(cliente);
	}

	private void validaObrigatoriedadeNome(Cliente cliente) {
		if (StringUtils.isEmpty(cliente.getNome()))
			throw new RestClientException("Informe o nome.");
	}
	
	private void validaObrigatoriedadeRisco(Cliente cliente) {
		if (StringUtils.isEmpty(cliente.getRisco()))
			throw new RestClientException("Informe o risco.");
	}
	
	private void validaObrigatoriedadeLimite(Cliente cliente) {
		if (cliente.getLimite() == null)
			throw new RestClientException("Informe o limite.");
	}


	public void setClienteRepository(ClienteRepository metricaRepository) {
		this.clienteRepository = metricaRepository;
	}

	public ArrayList<Cliente> listar() {
		return (ArrayList<Cliente>) clienteRepository.findAll();
	}
}