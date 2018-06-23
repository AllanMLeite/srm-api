package com.srm.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.client.RestClientException;

import com.srm.api.enums.RiscoEnum;
import com.srm.api.model.dto.ClienteDto;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private Double limite;
	private Character risco;
	private Double taxa;

	public Cliente() {
	}

	public Cliente(ClienteDto clienteDto) {
		validarCampos(clienteDto);
		nome = clienteDto.getNome();
		limite = clienteDto.getLimite();
		risco = clienteDto.getRisco();
		taxa = RiscoEnum.valueOf(risco.toString()).getTaxa();
	}

	private void validarCampos(ClienteDto clienteDto) {
		validarNome(clienteDto.getNome());
		validarLimite(clienteDto.getLimite());
		RiscoEnum.validarRisco(clienteDto.getRisco());
	}

	private void validarLimite(Double limite) {
		validarLimiteInformado(limite);
	}

	private void validarLimiteInformado(Double limite) {
		if (limite == null)
			throw new RestClientException("Informe o limite.");
	}

	private void validarNome(String nome) {
		validarNomeInformado(nome);
	}

	private void validarNomeInformado(String nome) {
		if (StringUtils.isBlank(nome))
			throw new RestClientException("Informe o nome.");
	}

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

	public Double getTaxa() {
		return taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}
}