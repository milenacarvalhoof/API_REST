package com.gft.sistema_politico.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.sistema_politico.exception.EntityNotFoundException;
import com.gft.sistema_politico.models.Prefeito;
import com.gft.sistema_politico.repositories.PrefeitoRepository;

@Service
public class PrefeitoService {
	
	private final PrefeitoRepository prefeitoRepository;

	public PrefeitoService(PrefeitoRepository prefeitoRepository) {
		this.prefeitoRepository = prefeitoRepository;
	}
	
	public Prefeito salvarPrefeito(Prefeito prefeito) {
		return prefeitoRepository.save(prefeito);
	}
	
	public Page<Prefeito> listarTodosOsPrefeitos(Pageable pageable){
		return prefeitoRepository.findAll(pageable);
	}
	
	public Prefeito buscarPrefeito(Long id) {
		Optional<Prefeito> prefeito = prefeitoRepository.findById(id);
		
		return prefeito.orElseThrow(() -> new EntityNotFoundException("Prefeito não encontrado!"));
	}
	
	public Prefeito atualizarPrefeito(Prefeito prefeito, Long id) {
		Prefeito prefeitoOriginal = this.buscarPrefeito(id);
		
		prefeito.setId(prefeitoOriginal.getId());
		
		return prefeitoRepository.save(prefeito);
	}
	
	public void excluirPrefeito(Long id) {
		Prefeito prefeito = this.buscarPrefeito(id);
		prefeitoRepository.delete(prefeito);
	}

}
