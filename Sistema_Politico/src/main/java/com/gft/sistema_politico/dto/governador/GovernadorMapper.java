package com.gft.sistema_politico.dto.governador;

import com.gft.sistema_politico.dto.endereco.EnderecoMapper;
import com.gft.sistema_politico.models.Governador;
import com.gft.sistema_politico.models.Partido;

public class GovernadorMapper {
	
	public static Governador fromDTO(RegistroGovernadorDTO dto) {
		
		Partido partido = new Partido();
		partido.setId(dto.getPartidoId());
		
		return new Governador(null, dto.getNome(), dto.getCpf(), EnderecoMapper.fromDTO(dto.getEndereco()), dto.getTelefone(), partido, dto.getProjetosDeLei(), dto.getProcessos(), dto.getFotos());
	}
	
	public static ConsultaGovernadorDTO fromEntity(Governador governador) {
		return new ConsultaGovernadorDTO(governador.getId(), governador.getNome(), governador.getCpf(), EnderecoMapper.fromEntity(governador.getEndereco()), governador.getTelefone(), governador.getPartido(), governador.getProjetosDeLei(), governador.getProcessos(), governador.getFotos());
	}

}
