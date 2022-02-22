package com.gft.sistema_politico.dto.presidente;

import com.gft.sistema_politico.dto.endereco.EnderecoDTO;
import com.gft.sistema_politico.models.Partido;

public class ConsultaPresidenteDTO {
	
	private Long id;	
	private String nome;	
	private String cpf;
	private EnderecoDTO endereco;	
	private String telefone;
	private Partido partido;
	private String projetosDeLei;
	private Boolean processos;
	private String fotos;
	
	public ConsultaPresidenteDTO() {}

	public ConsultaPresidenteDTO(Long id, String nome, String cpf, EnderecoDTO endereco, String telefone, Partido partido,
			String projetosDeLei, Boolean processos, String fotos) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
		this.telefone = telefone;
		this.partido = partido;
		this.projetosDeLei = projetosDeLei;
		this.processos = processos;
		this.fotos = fotos;
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

	public Partido getPartido() {
		return partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
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
