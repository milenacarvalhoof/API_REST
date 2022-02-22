package com.gft.sistema_politico_consumo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.sistema_politico_consumo.models.Politico;
import com.gft.sistema_politico_consumo.models.PoliticoResponse;
import com.gft.sistema_politico_consumo.services.DeputadoService;

@RestController
@RequestMapping("/deputados")
public class DeputadoController {
	
	@Autowired
	private DeputadoService politicoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Politico> obterPoliticoPorId(@PathVariable Long id){
		Politico politico = this.politicoService.obterPorId(id);
		
		return ResponseEntity.ok(politico);
	}
	
	@GetMapping
	public ResponseEntity<PoliticoResponse> obterTodosOsPoliticos(){
		
		PoliticoResponse lista = this.politicoService.obterTodos();
		
		return ResponseEntity.ok(lista);
	}
	
}
