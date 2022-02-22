package com.gft.sistema_politico.dto.deputado;

import com.gft.sistema_politico.dto.endereco.EnderecoMapper;
import com.gft.sistema_politico.models.Deputado;
import com.gft.sistema_politico.models.Partido;

public class DeputadoMapper {
	
	public static Deputado fromDTO(RegistroDeputadoDTO dto) {
		
		Partido partido = new Partido();
		partido.setId(dto.getPartidoId());
		
		return new Deputado(null, dto.getNome(), dto.getCpf(), EnderecoMapper.fromDTO(dto.getEndereco()), dto.getTelefone(), partido, dto.getProjetosDeLei(), dto.getProcessos(), dto.getFotos());
	}
	
	public static ConsultaDeputadoDTO fromEntity(Deputado deputado) {
		return new ConsultaDeputadoDTO(deputado.getId(), deputado.getNome(), deputado.getCpf(), EnderecoMapper.fromEntity(deputado.getEndereco()), deputado.getTelefone(), deputado.getPartido(), deputado.getProjetosDeLei(), deputado.getProcessos(), deputado.getFotos());
	}

}
