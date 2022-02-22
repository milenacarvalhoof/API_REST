package com.gft.sistema_politico.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.sistema_politico.exception.EntityNotFoundException;
import com.gft.sistema_politico.models.Ministro;
import com.gft.sistema_politico.repositories.MinistroRepository;

@Service
public class MinistroService {
	
	private final MinistroRepository ministroRepository;

	public MinistroService(MinistroRepository ministroReposiory) {
		this.ministroRepository = ministroReposiory;
	}
	
	public Ministro salvarMinistro(Ministro ministro) {
		return ministroRepository.save(ministro);
	}
	
	public Page<Ministro> listarTodosOsMinistros(Pageable pageable){
		return ministroRepository.findAll(pageable);
	}
	
	public Ministro buscarMinistro(Long id) {
		Optional<Ministro> ministro = ministroRepository.findById(id);
		
		return ministro.orElseThrow(() -> new EntityNotFoundException("Ministro não encontrado!"));
	}
	
	public Ministro atualizarMinistro (Ministro ministro, Long id) {
		Ministro ministroOriginal = this.buscarMinistro(id);
		
		ministro.setId(ministroOriginal.getId());
		
		return ministroRepository.save(ministro);
	}
	
	public void excluirMinistro(Long id) {
		Ministro ministro = this.buscarMinistro(id);
		ministroRepository.delete(ministro);
	}

}
