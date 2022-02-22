package com.gft.sistema_politico.controllers;

import javax.security.sasl.AuthenticationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.sistema_politico.dto.auth.AutenticacaoDTO;
import com.gft.sistema_politico.dto.auth.TokenDTO;
import com.gft.sistema_politico.services.AutenticacaoService;

@RestController
@RequestMapping("/v1/auth")
public class AutenticacaoController {
	
	private final AutenticacaoService authService;
	
	public AutenticacaoController(AutenticacaoService authService) {
		this.authService = authService;
	}
	
	@PostMapping
	public ResponseEntity<TokenDTO> autenticar(@RequestBody AutenticacaoDTO autoForm){
		
		try {
			return ResponseEntity.ok(authService.autenticar(autoForm));
		}catch(AuthenticationException ae) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
		}
	}

}
