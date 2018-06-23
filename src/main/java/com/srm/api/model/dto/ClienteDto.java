package com.srm.api.model.dto;

public class ClienteDto {

	private String nome;
	private Double limite;
	private Character risco;

	public Double getLimite() {
		return limite;
	}

	public Character getRisco() {
		return risco;
	}

	public String getNome() {
		return nome;
	}
	
	public ClienteDto() {
		
	}

	public ClienteDto(String nome, Double limite, Character risco) {
		super();
		this.nome = nome;
		this.limite = limite;
		this.risco = risco;
	}
}
