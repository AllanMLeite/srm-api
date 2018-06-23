package com.srm.api.cucumber;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Before;
import org.springframework.web.client.RestClientException;

import com.srm.api.model.Cliente;
import com.srm.api.repository.ClienteRepository;
import com.srm.api.service.ClienteService;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class PassosParaIncluirMetricaTest {

	private String mensagemErro;
	private Cliente cliente;

	@Dado("^que estou incluindo um novo usuario$")
	public void que_estou_incluindo_um_novo_usuario() throws Throwable {
		cliente = new Cliente();
	}

	@Dado("^que informei \"(.*?)\" no campo \"(.*?)\"$")
	public void que_informei_no_campo(String valor, String campo) throws Throwable {
		FieldUtils.writeField(cliente, campo, valor, true);
	}

	@Quando("^incluir$")
	public void clico_em_Salvar() throws Throwable {
		ClienteService service = new ClienteService();
		service.setMetricaRepository(new ClienteRepository());

		try {
			 service.salvar(cliente);
		} catch (RestClientException e) {
			mensagemErro = e.getMessage();
		}
	}

	@Entao("^exibe \"([^\"]*)\"$")
	public void o_sistema_exibe_a_mensagem(String mensagemEsperada) throws Throwable {
		assertEquals(mensagemEsperada, mensagemErro);
	}
}
