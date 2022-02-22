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

import com.gft.sistema_politico.dto.vereador.ConsultaVereadorDTO;
import com.gft.sistema_politico.dto.vereador.RegistroVereadorDTO;
import com.gft.sistema_politico.dto.vereador.VereadorMapper;
import com.gft.sistema_politico.models.Vereador;
import com.gft.sistema_politico.services.VereadorService;

@RestController
@RequestMapping("v1/vereadores")
public class VereadorController {
		
	private final VereadorService vereadorService;

	public VereadorController(VereadorService vereadorService) {
		this.vereadorService = vereadorService;
	}
	
	@GetMapping
	public ResponseEntity<Page<ConsultaVereadorDTO>> buscarTodosVereadores(@PageableDefault Pageable pageable){
		
		return ResponseEntity.ok(vereadorService.listarTodosOsVereadores(pageable).map(VereadorMapper::fromEntity));
	}
	
	@PostMapping
	public ResponseEntity<ConsultaVereadorDTO> salvarVereador(@RequestBody RegistroVereadorDTO dto){
				
		Vereador vereador = vereadorService.salvarVereador(VereadorMapper.fromDTO(dto));
		
		return ResponseEntity.ok(VereadorMapper.fromEntity(vereador));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ConsultaVereadorDTO> buscarVereador(@PathVariable Long id) {
		
		Vereador vereador = vereadorService.buscarVereador(id);
			
		return ResponseEntity.ok(VereadorMapper.fromEntity(vereador));
		
	}
	
	@PutMapping("{id}")
	public Vereador atualizarVereador(@RequestBody RegistroVereadorDTO dto, @PathVariable Long id){
		
		Vereador vereador = vereadorService.atualizarVereador(VereadorMapper.fromDTO(dto), id);
		return vereadorService.salvarVereador(vereador);

	}

	
	@DeleteMapping("{id}")
	public ResponseEntity<ConsultaVereadorDTO> excluirVereador(@PathVariable Long id) {
				
		try {
			
			vereadorService.excluirVereador(id);
			
			return ResponseEntity.ok().build();
			
		} catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
		
	}

}
