package com.gft.sistema_politico.dto.usuario;

public class RegistroUsuarioDTO {
	
	private String usuario;
	private String senha;
	private Long perfilId;
	
	public RegistroUsuarioDTO() {}
	
	public RegistroUsuarioDTO(String usuario, String senha, Long perfilId) {
		this.usuario = usuario;
		this.senha = senha;
		this.perfilId = perfilId;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getPerfilId() {
		return perfilId;
	}

	public void setPerfilId(Long perfilId) {
		this.perfilId = perfilId;
	}
}
