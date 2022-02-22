package com.gft.sistema_politico.dto.partido;

public class RegistroPartidoDTO {
	
	private String nome;	
	private String sigla;
	private String representante;
	
	public RegistroPartidoDTO() {}

	public RegistroPartidoDTO(String nome, String sigla, String representante) {
		this.nome = nome;
		this.sigla = sigla;
		this.representante = representante;
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
