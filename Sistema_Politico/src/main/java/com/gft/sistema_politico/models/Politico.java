package com.gft.sistema_politico.models;

import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.hibernate.validator.constraints.br.CPF;

@MappedSuperclass
public class Politico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@CPF
	private String cpf;
	
	@Embedded
	private Endereco endereco;
	
	private String telefone;
	
	@ManyToOne
	private Partido partido;
	
	private String projetosDeLei;
	
	private Boolean processos;
	
	private String fotos;
	
	public Politico() {}

	public Politico(Long id, String nome, String cpf, Endereco endereco, String telefone, Partido partido,
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
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
