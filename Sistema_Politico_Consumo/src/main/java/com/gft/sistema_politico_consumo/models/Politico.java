package com.gft.sistema_politico_consumo.models;

public class Politico {
	
	private Long id;
	private String nome;
	private Partido partido;
	private String projetosDeLei;
	private Boolean processos;

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
	@Override
	public String toString() {
		return "Politico [id=" + id + ", nome=" + nome + ", partido=" + partido + ", projetosDeLei=" + projetosDeLei
				+ ", processos=" + processos + "]";
	}
	
	
}
