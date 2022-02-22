package com.gft.sistema_politico.dto.usuario;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gft.sistema_politico.models.Perfil;
import com.gft.sistema_politico.models.Usuario;

public class UsuarioMapper {
	
	public static Usuario fromDTO(RegistroUsuarioDTO dto) {
		
		Perfil perfil = new Perfil();
		perfil.setId(dto.getPerfilId());
		
		return new Usuario(null, dto.getUsuario(), new BCryptPasswordEncoder().encode(dto.getSenha()), perfil);
	}
	
	public static ConsultaUsuarioDTO fromEntity(Usuario usuario) {
		
		return new ConsultaUsuarioDTO(usuario.getUsuario(), usuario.getPerfil().getNome());
	
	}

}
