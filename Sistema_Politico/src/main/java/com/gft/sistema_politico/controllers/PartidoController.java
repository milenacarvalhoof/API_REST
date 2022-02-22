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

import com.gft.sistema_politico.dto.partido.ConsultaPartidoDTO;
import com.gft.sistema_politico.dto.partido.PartidoMapper;
import com.gft.sistema_politico.dto.partido.RegistroPartidoDTO;
import com.gft.sistema_politico.models.Partido;
import com.gft.sistema_politico.services.PartidoService;

@RestController
@RequestMapping("v1/partidos")
public class PartidoController {
	
	private final PartidoService partidoService;

	public PartidoController(PartidoService partidoService) {
		this.partidoService = partidoService;
	}
	
	@GetMapping
	public ResponseEntity<Page<ConsultaPartidoDTO>> buscarTodosPartidos(@PageableDefault Pageable pageable){
		
		return ResponseEntity.ok(partidoService.listarTodosOsPartidos(pageable).map(PartidoMapper::fromEntity));
	}
	
	@PostMapping
	public ResponseEntity<ConsultaPartidoDTO> salvarPartido(@RequestBody RegistroPartidoDTO dto){
				
		Partido partido = partidoService.salvarPartido(PartidoMapper.fromDTO(dto));
		
		return ResponseEntity.ok(PartidoMapper.fromEntity(partido));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ConsultaPartidoDTO> buscarPartido(@PathVariable Long id) {
		
		Partido partido = partidoService.buscarPartido(id);
			
		return ResponseEntity.ok(PartidoMapper.fromEntity(partido));
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ConsultaPartidoDTO> atualizarPartido(@RequestBody RegistroPartidoDTO dto, @PathVariable Long id){
		
		try {
			
			Partido partido = partidoService.atualizarPartido(PartidoMapper.fromDTO(dto), id);
			return ResponseEntity.ok(PartidoMapper.fromEntity(partido));
		
		} catch (Exception ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ConsultaPartidoDTO> excluirPartido(@PathVariable Long id) {
				
		try {
			
			partidoService.excluirPartido(id);
			
			return ResponseEntity.ok().build();
			
		} catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}

}
