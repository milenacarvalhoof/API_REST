package com.gft.sistema_politico.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gft.sistema_politico.exception.EntityNotFoundException;
import com.gft.sistema_politico.models.Vereador;
import com.gft.sistema_politico.repositories.VereadorRepository;

@Service
public class VereadorService {
	
	private final VereadorRepository vereadorRepository;

	public VereadorService(VereadorRepository vereadorReposiory) {
		this.vereadorRepository = vereadorReposiory;
	}
	
	public Vereador salvarVereador(Vereador vereador) {
		return vereadorRepository.save(vereador);
	}
	
	public Page<Vereador> listarTodosOsVereadores(Pageable pageable){
		
		Page<Vereador> page = vereadorRepository.findAll(pageable);
		
		return page;
	}
	
	public Vereador buscarVereador(Long id) {
		Optional<Vereador> vereador = vereadorRepository.findById(id);
		
		return vereador.orElseThrow(() -> new EntityNotFoundException("Vereador não encontrado!"));
	}
	
	public Vereador atualizarVereador (Vereador vereador, Long id) {
		Vereador vereadorOriginal = this.buscarVereador(id);
		
		vereador.setId(vereadorOriginal.getId());
		
		return vereadorRepository.save(vereador);
	}
	
	public void excluirVereador(Long id) {
		Vereador vereador = this.buscarVereador(id);
		vereadorRepository.delete(vereador);
	}

}
