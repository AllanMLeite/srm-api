package com.srm.api.enums;

import org.springframework.web.client.RestClientException;

public enum RiscoEnum {
	A(0d), B(10d), C(20d);

	private RiscoEnum(Double taxa) {
		this.taxa = taxa;
	}

	private Double taxa;

	public static void validarRisco(Character risco) {
		validarRiscoInformado(risco);
		validarRiscoExistente(risco);
	}
	
	private static void validarRiscoInformado(Character risco) {
		if (risco == null || Character.isWhitespace(risco))
			throw new RestClientException("Informe o risco.");
	}

	private static void validarRiscoExistente(Character risco) {
		try {
			valueOf(risco.toString());
		} catch (IllegalArgumentException e) {
			throw new RestClientException("O risco deve ser A, B ou C.");
		}
	}

	public Double getTaxa() {
		return taxa;
	}

	public Character getCodigo() {
		return name().charAt(0);
	}
}
