package com.srm.api.cucumber.cliente.incluir;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestClientException;

import com.srm.api.enums.RiscoEnum;
import com.srm.api.model.dto.ClienteDto;
import com.srm.api.service.ClienteService;

import cucumber.api.java.Before;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class IncluirClienteTest {

	@Autowired
	private ClienteService service;

	@Before
	public void initialize() {

	}

	@Test
	public void deveExibirMensagemQuandoNomeNulo() {
		try {
			ClienteDto clienteDto = new ClienteDto(null, 100d, RiscoEnum.A.getCodigo());
			service.salvar(clienteDto);
			Assert.fail("Nome não deveria ser preenchido.");
		} catch (RestClientException e) {
			Assert.assertEquals("Nome não deveria ser preenchido.", "Informe o nome.", e.getMessage());
		}
	}

	@Test
	public void deveExibirMensagemQuandoNomeNaoPreenchido() {
		try {
			ClienteDto clienteDto = new ClienteDto(" ", 100d, RiscoEnum.A.getCodigo());
			service.salvar(clienteDto);
			Assert.fail("Nome não deveria ser preenchido.");
		} catch (RestClientException e) {
			Assert.assertEquals("Nome não deveria ser preenchido.", "Informe o nome.", e.getMessage());
		}
	}

	@Test
	public void deveExibirMensagemQuandoLimiteNaoPreenchido() {
		try {
			ClienteDto clienteDto = new ClienteDto("Maria", null, RiscoEnum.A.getCodigo());
			service.salvar(clienteDto);
			Assert.fail("Limite não deveria ser preenchido.");
		} catch (RestClientException e) {
			Assert.assertEquals("Limite não deveria ser preenchido.", "Informe o limite.", e.getMessage());
		}
	}
	
	@Test
	public void deveExibirMensagemQuandoRiscoNaoPreenchido() {
		try {
			ClienteDto clienteDto = new ClienteDto("Maria", 20d, ' ');
			service.salvar(clienteDto);
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
			service.salvar(clienteDto);
			Assert.fail("Risco não deveria ser válido.");
		} catch (RestClientException e) {
			Assert.assertEquals("Risco não deveria ser válido.", "O risco deve ser A, B ou C.", e.getMessage());
		}
	}
}
