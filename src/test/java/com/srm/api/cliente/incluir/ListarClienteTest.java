package com.srm.api.cliente.incluir;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.srm.api.enums.RiscoEnum;
import com.srm.api.model.Cliente;
import com.srm.api.model.dto.ClienteDto;
import com.srm.api.service.ClienteService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ListarClienteTest extends BaseTeste {

	@Autowired
	private ClienteService clienteService;

	@After
	@Override
	public void finalizar() {
		limparBase();
	}

	@Test
	public void deveTrazerListaVaziaQuandoNaoTemCliente() {
		assertTrue(clienteService.listar().isEmpty());
	}

	@Test
	public void deveTrazerTodosOsRegistrosDaBase() {
		clienteService.salvar(new ClienteDto("Renan", 1d, RiscoEnum.A.getCodigo()));
		clienteService.salvar(new ClienteDto("Carla", 2d, RiscoEnum.B.getCodigo()));
		clienteService.salvar(new ClienteDto("Heleno", 3d, RiscoEnum.C.getCodigo()));
		assertEquals(3, clienteService.listar().size());
	}

	@Test
	public void deveTrazerClienteComValoresCorretos() {
		String nomeInformado = "Almir";
		Double limiteInformado = 171d;
		Character riscoInformado = RiscoEnum.C.getCodigo();
		ClienteDto clienteDto = new ClienteDto(nomeInformado, limiteInformado, riscoInformado);
		clienteService.salvar(clienteDto).getId();
		Cliente clienteIncluido = clienteService.listar().get(0);
		ComparadorCliente.compararValoresClienteIncluido(nomeInformado, limiteInformado, riscoInformado, RiscoEnum.C,
				clienteIncluido);
	}
}
