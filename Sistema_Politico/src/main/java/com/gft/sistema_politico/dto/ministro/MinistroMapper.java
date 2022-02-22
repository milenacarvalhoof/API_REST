package com.gft.sistema_politico.dto.ministro;

import com.gft.sistema_politico.dto.endereco.EnderecoMapper;
import com.gft.sistema_politico.models.Ministro;
import com.gft.sistema_politico.models.Partido;

public class MinistroMapper {
	
	public static Ministro fromDTO(RegistroMinistroDTO dto) {
		
		Partido partido = new Partido();
		partido.setId(dto.getPartidoId());
		
		return new Ministro(null, dto.getNome(), dto.getCpf(), EnderecoMapper.fromDTO(dto.getEndereco()), dto.getTelefone(), partido, dto.getProjetosDeLei(), dto.getProcessos(), dto.getFotos());
	}
	
	public static ConsultaMinistroDTO fromEntity(Ministro ministro) {
		return new ConsultaMinistroDTO(ministro.getId(), ministro.getNome(), ministro.getCpf(), EnderecoMapper.fromEntity(ministro.getEndereco()), ministro.getTelefone(), ministro.getPartido(), ministro.getProjetosDeLei(), ministro.getProcessos(), ministro.getFotos());
	}

}
