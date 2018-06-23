package com.srm.api.cucumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.lang.reflect.Field;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Before;
import org.springframework.web.client.RestClientException;

import com.srm.api.model.Cliente;
import com.srm.api.repository.ClienteRepository;
import com.srm.api.service.ClienteService;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class PassosParaIncluirClienteTest {

	private String mensagemErro;
	private Cliente cliente;

	@Dado("^que estou incluindo um novo cliente$")
	public void que_estou_incluindo_um_novo_usuario() throws Throwable {
		cliente = new Cliente();
		cliente.setNome("João");
		cliente.setRisco('A');
	}

	@Dado("^que informei \"(.*?)\" no campo \"(.*?)\"$")
	public void que_informei_no_campo(String valor, String campo) throws Throwable {

		Field campoEncontrado = FieldUtils.getField(cliente.getClass(), campo, true);

		if (StringUtils.isBlank(valor)) {
			FieldUtils.writeField(cliente, campo, null, true);
			return;
		}

		if (campoEncontrado.getType().isAssignableFrom(Character.class)) {
			FieldUtils.writeField(cliente, campo, valor.charAt(0), true);
		} else {
			FieldUtils.writeField(cliente, campo, valor, true);
		}
	}

	@Quando("^incluir$")
	public void clico_em_Salvar() throws Throwable {
		ClienteService service = new ClienteService();
		service.setMetricaRepository(new ClienteRepository());

		try {
			assertNull(cliente.getId());
			cliente = service.salvar(cliente);
		} catch (RestClientException e) {
			mensagemErro = e.getMessage();
		}
	}

	@Entao("^exibe \"([^\"]*)\"$")
	public void o_sistema_exibe_a_mensagem(String mensagemEsperada) throws Throwable {
		assertEquals(mensagemEsperada, mensagemErro);
	}

	@Entao("^salva o cliente$")
	public void salva_o_cliente() throws Throwable {
		assertNotNull(cliente.getId());
	}

	@Entao("^nao exibe mensagem$")
	public void nao_exibe_mensagem() throws Throwable {
		assertNull(mensagemErro);
	}

}
