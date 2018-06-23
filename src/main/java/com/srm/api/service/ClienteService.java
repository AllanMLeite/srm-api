package com.srm.api.service;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestClientException;

import com.srm.api.model.Cliente;
import com.srm.api.repository.ClienteRepository;

@Service
public class ClienteService {

	@Resource
	private ClienteRepository clienteRepository;

	public Cliente salvar(Cliente cliente) {
		validarInclusao(cliente);
		return clienteRepository.incluir(cliente);
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
		return clienteRepository.listar();
	}
}