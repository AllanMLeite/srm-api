package com.srm.api.cliente.incluir;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestClientException;

import com.srm.api.enums.RiscoEnum;
import com.srm.api.model.Cliente;
import com.srm.api.model.dto.ClienteDto;
import com.srm.api.service.ClienteService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class IncluirClienteTest extends BaseTeste {

	@Autowired
	private ClienteService clienteService;

	@After
	@Override
	public void finalizar() {
		super.limparBase();
	}

	@Test
	public void deveExibirMensagemQuandoNomeNulo() {
		try {
			ClienteDto clienteDto = new ClienteDto(null, 100d, RiscoEnum.A.getCodigo());
			clienteService.salvar(clienteDto);
			fail("Nome não deveria ser preenchido.");
		} catch (RestClientException e) {
			assertEquals("Nome não deveria ser preenchido.", "Informe o nome.", e.getMessage());
			assertTrue(clienteService.listar().isEmpty());
		}
	}

	@Test
	public void deveExibirMensagemQuandoNomeNaoPreenchido() {
		try {
			ClienteDto clienteDto = new ClienteDto(" ", 100d, RiscoEnum.A.getCodigo());
			clienteService.salvar(clienteDto);
			fail("Nome não deveria ser preenchido.");
		} catch (RestClientException e) {
			assertEquals("Nome não deveria ser preenchido.", "Informe o nome.", e.getMessage());
			assertTrue(clienteService.listar().isEmpty());
		}
	}

	@Test
	public void deveExibirMensagemQuandoLimiteNaoPreenchido() {
		try {
			ClienteDto clienteDto = new ClienteDto("Maria", null, RiscoEnum.A.getCodigo());
			clienteService.salvar(clienteDto);
			fail("Limite não deveria ser preenchido.");
		} catch (RestClientException e) {
			assertEquals("Limite não deveria ser preenchido.", "Informe o limite.", e.getMessage());
			assertTrue(clienteService.listar().isEmpty());
		}
	}

	@Test
	public void deveExibirMensagemQuandoRiscoNaoPreenchido() {
		try {
			ClienteDto clienteDto = new ClienteDto("Maria", 20d, ' ');
			clienteService.salvar(clienteDto);
			fail("Risco não deveria ser preenchido.");
		} catch (RestClientException e) {
			assertEquals("Risco não deveria ser preenchido.", "Informe o risco.", e.getMessage());
			assertTrue(clienteService.listar().isEmpty());
		}
	}

	@Test
	public void deveExibirMensagemQuandoRiscoInvalido() {
		try {
			Character riscoInvalido = 'Z';
			ClienteDto clienteDto = new ClienteDto("Maria", 20d, riscoInvalido);
			clienteService.salvar(clienteDto);
			fail("Risco não deveria ser válido.");
		} catch (RestClientException e) {
			assertEquals("Risco não deveria ser válido.", "O risco deve ser A, B ou C.", e.getMessage());
			assertTrue(clienteService.listar().isEmpty());
		}
	}

	@Test
	public void deveIncluirUmClienteComRiscoA() {
		String nomeInformado = "Maria";
		Double limiteInformado = 20d;
		Character riscoInformado = RiscoEnum.A.getCodigo();
		ClienteDto clienteDto = new ClienteDto(nomeInformado, limiteInformado, riscoInformado);
		Long idCliente = clienteService.salvar(clienteDto).getId();
		Cliente clienteIncluido = clienteService.consultar(idCliente);
		ComparadorCliente.compararValoresClienteIncluido(nomeInformado, limiteInformado, riscoInformado, RiscoEnum.A,
				clienteIncluido);
	}

	@Test
	public void deveIncluirUmClienteComRiscoB() {
		String nomeInformado = "João";
		Double limiteInformado = 25d;
		Character riscoInformado = RiscoEnum.B.getCodigo();
		ClienteDto clienteDto = new ClienteDto(nomeInformado, limiteInformado, riscoInformado);
		Long idCliente = clienteService.salvar(clienteDto).getId();
		Cliente clienteIncluido = clienteService.consultar(idCliente);
		ComparadorCliente.compararValoresClienteIncluido(nomeInformado, limiteInformado, riscoInformado, RiscoEnum.B,
				clienteIncluido);
	}

	@Test
	public void deveIncluirUmClienteComRiscoC() {
		String nomeInformado = "Michele";
		Double limiteInformado = 30d;
		Character riscoInformado = RiscoEnum.C.getCodigo();
		ClienteDto clienteDto = new ClienteDto(nomeInformado, limiteInformado, riscoInformado);
		Long idCliente = clienteService.salvar(clienteDto).getId();
		Cliente clienteIncluido = clienteService.consultar(idCliente);
		ComparadorCliente.compararValoresClienteIncluido(nomeInformado, limiteInformado, riscoInformado, RiscoEnum.C,
				clienteIncluido);
	}
}
