package com.srm.api.cucumber.cliente.listar;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.apache.commons.lang3.reflect.FieldUtils;

import com.srm.api.model.Cliente;
import com.srm.api.repository.ClienteRepository;
import com.srm.api.service.ClienteService;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class PassosParaListarClienteTest {

	private ArrayList<Cliente> clientes;
	private ClienteService service;

	@Dado("^que existe um cliente cadastrado chamado \"(.*?)\" com limite \"(.*?)\", risco \"(.*?)\" e taxa \"(.*?)\"$")
	public void que_existe_um_cliente_cadastrado_chamado_com_limite_risco_e_taxa(String nome, Double limite,
			Character risco, Integer taxa) throws Throwable {
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setLimite(limite);
		cliente.setRisco(risco);
		cliente.setTaxa(taxa);
		service.salvar(cliente);
	}

	@Dado("^desejo visualizar os clientes cadastrados$")
	public void desejo_visualizar_os_clientes_cadastrados() throws Throwable {
		service = new ClienteService();
		service.setClienteRepository(new ClienteRepository());
	}

	@Quando("^listar$")
	public void listar() throws Throwable {
		clientes = service.listar();
	}

	@Entao("^o sistema exibe \"(.*?)\" clientes$")
	public void o_sistema_exibe_cliente(int total) throws Throwable {
		assertEquals(total, clientes.size());
	}

	@Entao("^retorna o valor \"(.*?)\" no campo \"(.*?)\"$")
	public void retorna_o_valor_no_campo(String valor, String campo) throws Throwable {
		Object campoEncontrado = FieldUtils.readField(clientes.get(0), campo, true);

		if (campoEncontrado instanceof Double) {
			assertEquals(Double.parseDouble(valor), campoEncontrado);
		} else {
			assertEquals(valor, campoEncontrado != null ? campoEncontrado.toString() : "");
		}
	}
}
