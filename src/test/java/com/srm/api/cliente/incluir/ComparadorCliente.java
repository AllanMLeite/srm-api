package com.srm.api.cliente.incluir;

import static org.junit.Assert.assertEquals;

import com.srm.api.enums.RiscoEnum;
import com.srm.api.model.Cliente;

public class ComparadorCliente {
	
	private ComparadorCliente() {
		
	}
	
	public static void compararValoresClienteIncluido(String nomeInformado, Double limiteInformado, Character riscoInformado,
			RiscoEnum riscoEnum, Cliente clienteIncluido) {
		assertEquals("Nome diferente do esperado.", nomeInformado, clienteIncluido.getNome());
		assertEquals("Limite diferente do esperado.", limiteInformado, clienteIncluido.getLimite());
		assertEquals("Risco diferente do esperado.", riscoInformado, clienteIncluido.getRisco());
		assertEquals("Taxa diferente do esperado", riscoEnum.getTaxa(), clienteIncluido.getTaxa());
	}
}
