package com.srm.api.cucumber.cliente.incluir;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
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
public class IncluirClienteTest {

	@Autowired
	private ClienteService clienteService;

	@Test
	public void deveExibirMensagemQuandoNomeNulo() {
		try {
			ClienteDto clienteDto = new ClienteDto(null, 100d, RiscoEnum.A.getCodigo());
			clienteService.salvar(clienteDto);
			Assert.fail("Nome não deveria ser preenchido.");
		} catch (RestClientException e) {
			Assert.assertEquals("Nome não deveria ser preenchido.", "Informe o nome.", e.getMessage());
		}
	}

	@Test
	public void deveExibirMensagemQuandoNomeNaoPreenchido() {
		try {
			ClienteDto clienteDto = new ClienteDto(" ", 100d, RiscoEnum.A.getCodigo());
			clienteService.salvar(clienteDto);
			Assert.fail("Nome não deveria ser preenchido.");
		} catch (RestClientException e) {
			Assert.assertEquals("Nome não deveria ser preenchido.", "Informe o nome.", e.getMessage());
		}
	}

	@Test
	public void deveExibirMensagemQuandoLimiteNaoPreenchido() {
		try {
			ClienteDto clienteDto = new ClienteDto("Maria", null, RiscoEnum.A.getCodigo());
			clienteService.salvar(clienteDto);
			Assert.fail("Limite não deveria ser preenchido.");
		} catch (RestClientException e) {
			Assert.assertEquals("Limite não deveria ser preenchido.", "Informe o limite.", e.getMessage());
		}
	}

	@Test
	public void deveExibirMensagemQuandoRiscoNaoPreenchido() {
		try {
			ClienteDto clienteDto = new ClienteDto("Maria", 20d, ' ');
			clienteService.salvar(clienteDto);
			Assert.fail("Risco não deveria ser preenchido.");
		} catch (RestClientException e) {
			Assert.assertEquals("Risco não deveria ser preenchido.", "Informe o risco.", e.getMessage());
		}
	}

	@Test
	public void deveExibirMensagemQuandoRiscoInvalido() {
		try {
			Character riscoInvalido = 'Z';
			ClienteDto clienteDto = new ClienteDto("Maria", 20d, riscoInvalido);
			clienteService.salvar(clienteDto);
			Assert.fail("Risco não deveria ser válido.");
		} catch (RestClientException e) {
			Assert.assertEquals("Risco não deveria ser válido.", "O risco deve ser A, B ou C.", e.getMessage());
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

		compararValoresClienteIncluido(nomeInformado, limiteInformado, riscoInformado, RiscoEnum.A, clienteIncluido);
	}

	@Test
	public void deveIncluirUmClienteComRiscoB() {
		String nomeInformado = "João";
		Double limiteInformado = 25d;
		Character riscoInformado = RiscoEnum.B.getCodigo();

		ClienteDto clienteDto = new ClienteDto(nomeInformado, limiteInformado, riscoInformado);

		Long idCliente = clienteService.salvar(clienteDto).getId();
		Cliente clienteIncluido = clienteService.consultar(idCliente);

		compararValoresClienteIncluido(nomeInformado, limiteInformado, riscoInformado, RiscoEnum.B, clienteIncluido);
	}
	
	@Test
	public void deveIncluirUmClienteComRiscoC() {
		String nomeInformado = "Michele";
		Double limiteInformado = 30d;
		Character riscoInformado = RiscoEnum.C.getCodigo();

		ClienteDto clienteDto = new ClienteDto(nomeInformado, limiteInformado, riscoInformado);

		Long idCliente = clienteService.salvar(clienteDto).getId();
		Cliente clienteIncluido = clienteService.consultar(idCliente);

		compararValoresClienteIncluido(nomeInformado, limiteInformado, riscoInformado, RiscoEnum.C, clienteIncluido);
	}

	private void compararValoresClienteIncluido(String nomeInformado, Double limiteInformado, Character riscoInformado,
			RiscoEnum riscoEnum, Cliente clienteIncluido) {
		assertEquals("Nome diferente do esperado.", nomeInformado, clienteIncluido.getNome());
		assertEquals("Limite diferente do esperado.", limiteInformado, clienteIncluido.getLimite());
		assertEquals("Risco diferente do esperado.", riscoInformado, clienteIncluido.getRisco());
		assertEquals("Taxa diferente do esperado", riscoEnum.getTaxa(), clienteIncluido.getTaxa());
	}
}
