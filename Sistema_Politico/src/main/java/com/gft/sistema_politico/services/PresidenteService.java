package com.gft.sistema_politico.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.sistema_politico.exception.EntityNotFoundException;
import com.gft.sistema_politico.models.Presidente;
import com.gft.sistema_politico.repositories.PresidenteRepository;

@Service
public class PresidenteService {
	
	private final PresidenteRepository presidenteRepository;

	public PresidenteService(PresidenteRepository presidenteRepository) {
		this.presidenteRepository = presidenteRepository;
	}
	
	public Presidente salvarPresidente(Presidente presidente) {
		return presidenteRepository.save(presidente);
	}
	
	public Page<Presidente> listarTodosOsPresidentes(Pageable pageable){
		return presidenteRepository.findAll(pageable);
	}
	
	public Presidente buscarPresidente(Long id) {
		Optional<Presidente> presidente = presidenteRepository.findById(id);
		
		return presidente.orElseThrow(() -> new EntityNotFoundException("Presidente não encontrado!"));
	}
	
	public Presidente atualizarPresidente(Presidente presidente, Long id) {
		Presidente presidenteOriginal = this.buscarPresidente(id);
		
		presidente.setId(presidenteOriginal.getId());
		
		return presidenteRepository.save(presidente);
	}
	
	public void excluirPresidente(Long id) {
		Presidente presidente = this.buscarPresidente(id);
		presidenteRepository.delete(presidente);
	}

}
