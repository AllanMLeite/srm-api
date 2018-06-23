package com.srm.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.srm.api.model.Cliente;
import com.srm.api.service.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@RequestMapping(value = "/cliente", method = RequestMethod.POST)
	public Cliente incluir(@RequestBody Cliente cliente) {
		return null;//clienteService.salvar(cliente);
	}

	@RequestMapping(value = "/cliente", method = RequestMethod.GET)
	public List<Cliente> listar() {
		return clienteService.listar();
	}
}