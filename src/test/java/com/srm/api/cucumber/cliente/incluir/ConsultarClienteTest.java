package com.srm.api.cucumber.cliente.incluir;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.srm.api.enums.RiscoEnum;
import com.srm.api.model.dto.ClienteDto;
import com.srm.api.service.ClienteService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ConsultarClienteTest extends BaseTeste {

	@Autowired
	private ClienteService clienteService;
	
	@After
	@Override
	public void finalizar() {
		super.limparBase();
	}

	@Test
	public void deveRetornarUmCliente() {
		ClienteDto clienteDto = new ClienteDto("Daiane", 78998d, RiscoEnum.A.getCodigo());
		Long idCliente = clienteService.salvar(clienteDto).getId();
		assertNotNull(clienteService.consultar(idCliente));
	}

	@Test
	public void deveRetornarNuloParaUmClienteNaoExistente() {
		assertNull(clienteService.consultar(0l));
		assertNull(clienteService.consultar(-1l));
		assertNull(clienteService.consultar(999l));
	}
}
