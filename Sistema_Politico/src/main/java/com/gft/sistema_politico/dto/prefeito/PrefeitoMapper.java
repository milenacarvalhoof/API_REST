package com.gft.sistema_politico.dto.prefeito;

import com.gft.sistema_politico.dto.endereco.EnderecoMapper;
import com.gft.sistema_politico.models.Partido;
import com.gft.sistema_politico.models.Prefeito;

public class PrefeitoMapper {
	
	public static Prefeito fromDTO(RegistroPrefeitoDTO dto) {
		
		Partido partido = new Partido();
		partido.setId(dto.getPartidoId());
		
		return new Prefeito(null, dto.getNome(), dto.getCpf(), EnderecoMapper.fromDTO(dto.getEndereco()), dto.getTelefone(), partido, dto.getProjetosDeLei(), dto.getProcessos(), dto.getFotos());
	}
	
	public static ConsultaPrefeitoDTO fromEntity(Prefeito prefeito) {
		return new ConsultaPrefeitoDTO(prefeito.getId(), prefeito.getNome(), prefeito.getCpf(), EnderecoMapper.fromEntity(prefeito.getEndereco()), prefeito.getTelefone(), prefeito.getPartido(), prefeito.getProjetosDeLei(), prefeito.getProcessos(), prefeito.getFotos());
	}

}
