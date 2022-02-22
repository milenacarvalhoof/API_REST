package com.gft.sistema_politico.dto.presidente;

import com.gft.sistema_politico.dto.endereco.EnderecoMapper;
import com.gft.sistema_politico.models.Partido;
import com.gft.sistema_politico.models.Presidente;

public class PresidenteMapper {
	
	public static Presidente fromDTO(RegistroPresidenteDTO dto) {
		
		Partido partido = new Partido();
		partido.setId(dto.getPartidoId());
		
		return new Presidente(null, dto.getNome(), dto.getCpf(), EnderecoMapper.fromDTO(dto.getEndereco()), dto.getTelefone(), partido, dto.getProjetosDeLei(), dto.getProcessos(), dto.getFotos());
	}
	
	public static ConsultaPresidenteDTO fromEntity(Presidente presidente) {
		return new ConsultaPresidenteDTO(presidente.getId(), presidente.getNome(), presidente.getCpf(), EnderecoMapper.fromEntity(presidente.getEndereco()), presidente.getTelefone(), presidente.getPartido(), presidente.getProjetosDeLei(), presidente.getProcessos(), presidente.getFotos());
	}

}
