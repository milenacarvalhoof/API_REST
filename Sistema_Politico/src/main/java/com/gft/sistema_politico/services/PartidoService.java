package com.gft.sistema_politico.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.sistema_politico.exception.EntityNotFoundException;
import com.gft.sistema_politico.models.Partido;
import com.gft.sistema_politico.repositories.PartidoRepository;

@Service
public class PartidoService {
	
	private final PartidoRepository partidoRepository;

	public PartidoService(PartidoRepository partidoRepository) {
		this.partidoRepository = partidoRepository;
	}
	
	public Partido salvarPartido(Partido partido) {
		return partidoRepository.save(partido);
	}
	
	public Page<Partido> listarTodosOsPartidos(Pageable pageable){
		return partidoRepository.findAll(pageable);
	}
	
	public Partido buscarPartido(Long id) {
		Optional<Partido> partido = partidoRepository.findById(id);
		
		return partido.orElseThrow(() -> new EntityNotFoundException("Partido não encontrado!"));
	}
	
	public Partido atualizarPartido(Partido partido, Long id) {
		Partido partidoOriginal = this.buscarPartido(id);
		
		partido.setId(partidoOriginal.getId());
		
		return partidoRepository.save(partido);
	}
	
	public void excluirPartido(Long id) {
		Partido partido = this.buscarPartido(id);
		partidoRepository.delete(partido);
	}

}
