package com.gft.sistema_politico.dto.usuario;

public class ConsultaUsuarioDTO {
	
	private String usuario;
	private String nomePerfil;
	
	public ConsultaUsuarioDTO() {}

	public ConsultaUsuarioDTO(String usuario, String nomePerfil) {
		this.usuario = usuario;
		this.nomePerfil = nomePerfil;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getNomePerfil() {
		return nomePerfil;
	}

	public void setNomePerfil(String nomePerfil) {
		this.nomePerfil = nomePerfil;
	}
	
}
