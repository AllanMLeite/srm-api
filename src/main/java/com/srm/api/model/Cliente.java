package com.srm.api.model;

public class Cliente {

    private Long id;
    private String nome;
    private Double limite;
    private Character risco;
    private Integer taxa;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getLimite() {
		return limite;
	}
	public void setLimite(Double limite) {
		this.limite = limite;
	}
	public Character getRisco() {
		return risco;
	}
	public void setRisco(Character risco) {
		this.risco = risco;
	}
	public Integer getTaxa() {
		return taxa;
	}
	public void setTaxa(Integer taxa) {
		this.taxa = taxa;
	}
}