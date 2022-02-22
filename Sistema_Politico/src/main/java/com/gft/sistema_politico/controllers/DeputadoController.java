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

import com.gft.sistema_politico.dto.deputado.ConsultaDeputadoDTO;
import com.gft.sistema_politico.dto.deputado.DeputadoMapper;
import com.gft.sistema_politico.dto.deputado.RegistroDeputadoDTO;
import com.gft.sistema_politico.models.Deputado;
import com.gft.sistema_politico.services.DeputadoService;

@RestController
@RequestMapping("v1/deputados")
public class DeputadoController {
	
	private final DeputadoService deputadoService;

	public DeputadoController(DeputadoService partidoService) {
		this.deputadoService = partidoService;
	}
	
	@GetMapping
	public ResponseEntity<Page<ConsultaDeputadoDTO>> buscarTodosDeputados(@PageableDefault Pageable pageable){
		
		return ResponseEntity.ok(deputadoService.listarTodosOsDeputados(pageable).map(DeputadoMapper::fromEntity));
	}
	
	@PostMapping
	public ResponseEntity<ConsultaDeputadoDTO> salvarDeputado(@RequestBody RegistroDeputadoDTO dto){
				
		Deputado deputado = deputadoService.salvarDeputado(DeputadoMapper.fromDTO(dto));
		
		return ResponseEntity.ok(DeputadoMapper.fromEntity(deputado));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ConsultaDeputadoDTO> buscarDeputado(@PathVariable Long id) {
		
		Deputado deputado = deputadoService.buscarDeputado(id);
			
		return ResponseEntity.ok(DeputadoMapper.fromEntity(deputado));
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<ConsultaDeputadoDTO> atualizarDeputado(@RequestBody RegistroDeputadoDTO dto, @PathVariable Long id){
		
		try {
			
			Deputado deputado = deputadoService.atualizarDeputado(DeputadoMapper.fromDTO(dto), id);
			return ResponseEntity.ok(DeputadoMapper.fromEntity(deputado));
		
		} catch (Exception ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<ConsultaDeputadoDTO> excluirDeputado(@PathVariable Long id) {
				
		try {
			
			deputadoService.excluirDeputado(id);
			
			return ResponseEntity.ok().build();
			
		} catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}

}
