package com.gft.sistema_politico_consumo.models;

public class Partido {
	
	private Long id;
	
	private String nome;
	
	private String sigla;
	
	private String representante;
	
	public Partido() {}

	public Partido(Long id, String nome, String sigla, String representante) {
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
		this.representante = representante;
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getRepresentante() {
		return representante;
	}

	public void setRepresentante(String representante) {
		this.representante = representante;
	}
	
}
