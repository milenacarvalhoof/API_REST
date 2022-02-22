package com.gft.sistema_politico.dto.vereador;

import com.gft.sistema_politico.dto.endereco.EnderecoMapper;
import com.gft.sistema_politico.models.Partido;
import com.gft.sistema_politico.models.Vereador;

public class VereadorMapper {
	
	public static Vereador fromDTO(RegistroVereadorDTO dto) {
		
		Partido partido = new Partido();
		partido.setId(dto.getPartidoId());
		
		return new Vereador(null, dto.getNome(), dto.getCpf(), EnderecoMapper.fromDTO(dto.getEndereco()), dto.getTelefone(), partido, dto.getProjetosDeLei(), dto.getProcessos(), dto.getFotos());
	}
	
	public static ConsultaVereadorDTO fromEntity(Vereador vereador) {
		return new ConsultaVereadorDTO(vereador.getId(), vereador.getNome(), vereador.getCpf(), EnderecoMapper.fromEntity(vereador.getEndereco()), vereador.getTelefone(), vereador.getPartido(), vereador.getProjetosDeLei(), vereador.getProcessos(), vereador.getFotos());
	}

}
