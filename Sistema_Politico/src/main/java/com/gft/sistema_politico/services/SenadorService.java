package com.gft.sistema_politico.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.sistema_politico.exception.EntityNotFoundException;
import com.gft.sistema_politico.models.Senador;
import com.gft.sistema_politico.repositories.SenadorRepository;

@Service
public class SenadorService {
	
	private final SenadorRepository senadorRepository;

	public SenadorService(SenadorRepository senadorRepository) {
		this.senadorRepository = senadorRepository;
	}
	
	public Senador salvarSenador(Senador senador) {
		return senadorRepository.save(senador);
	}
	
	public Page<Senador> listarTodosOsSenadores(Pageable pageable){
		return senadorRepository.findAll(pageable);
	}
	
	public Senador buscarSenador(Long id) {
		Optional<Senador> senador = senadorRepository.findById(id);
		
		return senador.orElseThrow(() -> new EntityNotFoundException("Senador não encontrado!"));
	}
	
	public Senador atualizarSenador(Senador senador, Long id) {
		Senador senadorOriginal = this.buscarSenador(id);
		
		senador.setId(senadorOriginal.getId());
		
		return senadorRepository.save(senador);
	}
	
	public void excluirSenador(Long id) {
		Senador senador = this.buscarSenador(id);
		senadorRepository.delete(senador);
	}

}
