package com.gft.sistema_politico.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.sistema_politico.exception.EntityNotFoundException;
import com.gft.sistema_politico.models.Deputado;
import com.gft.sistema_politico.repositories.DeputadoRepository;

@Service
public class DeputadoService {
	
	private final DeputadoRepository deputadoRepository;

	public DeputadoService(DeputadoRepository deputadoReposiory) {
		this.deputadoRepository = deputadoReposiory;
	}
	
	public Deputado salvarDeputado(Deputado deputado) {
		return deputadoRepository.save(deputado);		
	}
	
	public Page<Deputado> listarTodosOsDeputados(Pageable pageable){
		return deputadoRepository.findAll(pageable);
	}
	
	public Deputado buscarDeputado(Long id) {
		Optional<Deputado> deputado = deputadoRepository.findById(id);
		
		return deputado.orElseThrow(() -> new EntityNotFoundException("Deputado não encontrado!"));
	}
	
	public Deputado atualizarDeputado (Deputado deputado, Long id) {
		Deputado deputadoOriginal = this.buscarDeputado(id);
		
		deputado.setId(deputadoOriginal.getId());
		
		return deputadoRepository.save(deputado);
	}
	
	public void excluirDeputado(Long id) {
		Deputado deputado = this.buscarDeputado(id);
		deputadoRepository.delete(deputado);
	}

}
