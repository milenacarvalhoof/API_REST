package com.gft.sistema_politico.dto.partido;

import com.gft.sistema_politico.models.Partido;

public class PartidoMapper {
	
	public static Partido fromDTO(RegistroPartidoDTO dto) {
				
		return new Partido(null, dto.getNome(), dto.getSigla(), dto.getRepresentante());
	}
	public static ConsultaPartidoDTO fromEntity(Partido partido) {
		return new ConsultaPartidoDTO(partido.getId(), partido.getNome(), partido.getSigla(), partido.getRepresentante());
	}

}
