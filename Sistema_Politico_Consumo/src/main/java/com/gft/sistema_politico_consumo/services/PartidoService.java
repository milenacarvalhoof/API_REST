package com.gft.sistema_politico_consumo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.gft.sistema_politico_consumo.models.Partido;
import com.gft.sistema_politico_consumo.models.PartidoResponse;

import reactor.core.publisher.Mono;

@Service
public class PartidoService {
	
	@Autowired
	private WebClient webClient;

	public Partido obterPorId(Long id) {
		
		Mono<Partido> mono = this.webClient
			.method(HttpMethod.GET)
			.uri("/partidos/{id}", id)
			.retrieve()
			.bodyToMono(Partido.class);
				
		Partido partido = mono.block();
		
		return partido;
	}
	
	public PartidoResponse obterTodos() {
		
		Mono<PartidoResponse> mono = this.webClient
			.method(HttpMethod.GET)
			.uri("/partidos")			
			.retrieve()
			.bodyToMono(new ParameterizedTypeReference<PartidoResponse>() {});
		
		PartidoResponse lista = mono.block();
		
		return lista;
		
	}


}
