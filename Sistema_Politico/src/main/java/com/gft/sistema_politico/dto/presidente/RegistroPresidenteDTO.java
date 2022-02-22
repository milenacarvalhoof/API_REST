package com.gft.sistema_politico.dto.presidente;

import com.gft.sistema_politico.dto.endereco.EnderecoDTO;

public class RegistroPresidenteDTO {
	
	private String nome;	
	private String cpf;
	private EnderecoDTO endereco;	
	private String telefone;
	private Long partidoId;
	private String projetosDeLei;
	private Boolean processos;
	private String fotos;
	
	public RegistroPresidenteDTO() {}

	public RegistroPresidenteDTO(String nome, String cpf, EnderecoDTO endereco, String telefone, Long partidoId,
			String projetosDeLei, Boolean processos, String fotos) {
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.partidoId = partidoId;
		this.processos = processos;
		this.projetosDeLei = projetosDeLei;
		this.fotos = fotos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Long getPartidoId() {
		return partidoId;
	}

	public void setPartidoId(Long partidoId) {
		this.partidoId = partidoId;
	}
	
	public String getProjetosDeLei() {
		return projetosDeLei;
	}

	public void setProjetosDeLei(String projetosDeLei) {
		this.projetosDeLei = projetosDeLei;
	}

	public Boolean getProcessos() {
		return processos;
	}

	public void setProcessos(Boolean processos) {
		this.processos = processos;
	}

	public String getFotos() {
		return fotos;
	}

	public void setFotos(String fotos) {
		this.fotos = fotos;
	}
	
}
