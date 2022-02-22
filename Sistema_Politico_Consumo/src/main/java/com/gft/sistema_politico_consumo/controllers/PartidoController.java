package com.gft.sistema_politico_consumo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.sistema_politico_consumo.models.Partido;
import com.gft.sistema_politico_consumo.models.PartidoResponse;
import com.gft.sistema_politico_consumo.services.PartidoService;

@RestController
@RequestMapping("/partidos")
public class PartidoController {
	
	@Autowired
	private PartidoService partidoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Partido> obterPartidoPorId(@PathVariable Long id){
		Partido partido = this.partidoService.obterPorId(id);
		
		return ResponseEntity.ok(partido);
	}
	
	@GetMapping
	public ResponseEntity<PartidoResponse> obterTodosOsPartidos(){
		
		PartidoResponse lista = this.partidoService.obterTodos();
		
		return ResponseEntity.ok(lista);
	}
	
}
