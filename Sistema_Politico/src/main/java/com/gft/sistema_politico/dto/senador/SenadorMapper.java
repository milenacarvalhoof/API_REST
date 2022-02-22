package com.gft.sistema_politico.dto.senador;

import com.gft.sistema_politico.dto.endereco.EnderecoMapper;
import com.gft.sistema_politico.models.Partido;
import com.gft.sistema_politico.models.Senador;

public class SenadorMapper {
	
	public static Senador fromDTO(RegistroSenadorDTO dto) {
		
		Partido partido = new Partido();
		partido.setId(dto.getPartidoId());
		
		return new Senador(null, dto.getNome(), dto.getCpf(), EnderecoMapper.fromDTO(dto.getEndereco()), dto.getTelefone(), partido, dto.getProjetosDeLei(), dto.getProcessos(), dto.getFotos());
	}
	
	public static ConsultaSenadorDTO fromEntity(Senador senador) {
		return new ConsultaSenadorDTO(senador.getId(), senador.getNome(), senador.getCpf(), EnderecoMapper.fromEntity(senador.getEndereco()), senador.getTelefone(), senador.getPartido(), senador.getProjetosDeLei(), senador.getProcessos(), senador.getFotos());
	}

}
