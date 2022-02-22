package com.gft.sistema_politico.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.sistema_politico.dto.presidente.ConsultaPresidenteDTO;
import com.gft.sistema_politico.dto.presidente.PresidenteMapper;
import com.gft.sistema_politico.dto.presidente.RegistroPresidenteDTO;
import com.gft.sistema_politico.models.Presidente;
import com.gft.sistema_politico.services.PresidenteService;

@RestController
@RequestMapping("v1/presidentes")
public class PresidenteController {
	
	private final PresidenteService presidenteService;

	public PresidenteController(PresidenteService presidenteService) {
		this.presidenteService = presidenteService;
	}
	
	@GetMapping
	public ResponseEntity<Page<ConsultaPresidenteDTO>> buscarTodosPresidentes(@PageableDefault Pageable pageable){
		
		return ResponseEntity.ok(presidenteService.listarTodosOsPresidentes(pageable).map(PresidenteMapper::fromEntity));
	}
	
	@PostMapping
	public ResponseEntity<ConsultaPresidenteDTO> salvarPresidente(@RequestBody RegistroPresidenteDTO dto){
				
		Presidente presidente = presidenteService.salvarPresidente(PresidenteMapper.fromDTO(dto));
		
		return ResponseEntity.ok(PresidenteMapper.fromEntity(presidente));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ConsultaPresidenteDTO> buscarPresidente(@PathVariable Long id) {
		
		Presidente presidente = presidenteService.buscarPresidente(id);
			
		return ResponseEntity.ok(PresidenteMapper.fromEntity(presidente));
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ConsultaPresidenteDTO> atualizarPresidente(@RequestBody RegistroPresidenteDTO dto, @PathVariable Long id){
		
		try {
			
			Presidente presidente = presidenteService.atualizarPresidente(PresidenteMapper.fromDTO(dto), id);
			return ResponseEntity.ok(PresidenteMapper.fromEntity(presidente));
		
		} catch (Exception ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ConsultaPresidenteDTO> excluirPresidente(@PathVariable Long id) {
				
		try {
			
			presidenteService.excluirPresidente(id);
			
			return ResponseEntity.ok().build();
			
		} catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}

}
