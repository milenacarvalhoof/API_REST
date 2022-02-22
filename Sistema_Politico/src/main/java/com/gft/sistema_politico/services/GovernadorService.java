package com.gft.sistema_politico.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.sistema_politico.exception.EntityNotFoundException;
import com.gft.sistema_politico.models.Governador;
import com.gft.sistema_politico.repositories.GovernadorRepository;

@Service
public class GovernadorService {
	
	private final GovernadorRepository governadorRepository;

	public GovernadorService(GovernadorRepository governadorReposiory) {
		this.governadorRepository = governadorReposiory;
	}
	
	public Governador salvarGovernador(Governador governador) {
		return governadorRepository.save(governador);
	}
	
	public Page<Governador> listarTodosOsGovernadores(Pageable pageable){
		return governadorRepository.findAll(pageable);
	}
	
	public Governador buscarGovernador(Long id) {
		Optional<Governador> governador = governadorRepository.findById(id);
		
		return governador.orElseThrow(() -> new EntityNotFoundException("Governador não encontrado!"));
	}
	
	public Governador atualizarGovernador (Governador governador, Long id) {
		Governador governadorOriginal = this.buscarGovernador(id);
		
		governador.setId(governadorOriginal.getId());
		
		return governadorRepository.save(governador);
	}
	
	public void excluirGovernador(Long id) {
		Governador governador = this.buscarGovernador(id);
		governadorRepository.delete(governador);
	}

}
