package com.gft.sistema_politico_consumo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.gft.sistema_politico_consumo.models.Politico;
import com.gft.sistema_politico_consumo.models.PoliticoResponse;

import reactor.core.publisher.Mono;

@Service
public class GovernadorService {
	
	@Autowired
	private WebClient webClient;
	
	public Politico obterPorId(Long id) {
		
		Mono<Politico> mono = this.webClient
			.method(HttpMethod.GET)
			.uri("/governadores/{id}", id)
			.retrieve()
			.bodyToMono(Politico.class);
				
		Politico politico = mono.block();
		
		return politico;
	}
	
	public PoliticoResponse obterTodos() {
		
		Mono<PoliticoResponse> mono = this.webClient
			.method(HttpMethod.GET)
			.uri("/governadores")			
			.retrieve()
			.bodyToMono(new ParameterizedTypeReference<PoliticoResponse>() {});
		
		PoliticoResponse lista = mono.block();
		
		return lista;
		
	}


}
