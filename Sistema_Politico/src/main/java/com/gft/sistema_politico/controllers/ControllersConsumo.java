package com.gft.sistema_politico.controllers;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gft.sistema_politico.dto.deputado.ConsultaDeputadoDTO;
import com.gft.sistema_politico.dto.deputado.DeputadoMapper;
import com.gft.sistema_politico.dto.governador.ConsultaGovernadorDTO;
import com.gft.sistema_politico.dto.governador.GovernadorMapper;
import com.gft.sistema_politico.dto.ministro.ConsultaMinistroDTO;
import com.gft.sistema_politico.dto.ministro.MinistroMapper;
import com.gft.sistema_politico.dto.partido.ConsultaPartidoDTO;
import com.gft.sistema_politico.dto.partido.PartidoMapper;
import com.gft.sistema_politico.dto.prefeito.ConsultaPrefeitoDTO;
import com.gft.sistema_politico.dto.prefeito.PrefeitoMapper;
import com.gft.sistema_politico.dto.presidente.ConsultaPresidenteDTO;
import com.gft.sistema_politico.dto.presidente.PresidenteMapper;
import com.gft.sistema_politico.dto.senador.ConsultaSenadorDTO;
import com.gft.sistema_politico.dto.senador.SenadorMapper;
import com.gft.sistema_politico.dto.vereador.ConsultaVereadorDTO;
import com.gft.sistema_politico.dto.vereador.VereadorMapper;
import com.gft.sistema_politico.models.Deputado;
import com.gft.sistema_politico.models.Governador;
import com.gft.sistema_politico.models.Ministro;
import com.gft.sistema_politico.models.Partido;
import com.gft.sistema_politico.models.Prefeito;
import com.gft.sistema_politico.models.Presidente;
import com.gft.sistema_politico.models.Senador;
import com.gft.sistema_politico.models.Vereador;
import com.gft.sistema_politico.services.DeputadoService;
import com.gft.sistema_politico.services.GovernadorService;
import com.gft.sistema_politico.services.MinistroService;
import com.gft.sistema_politico.services.PartidoService;
import com.gft.sistema_politico.services.PrefeitoService;
import com.gft.sistema_politico.services.PresidenteService;
import com.gft.sistema_politico.services.SenadorService;
import com.gft.sistema_politico.services.VereadorService;

@RestController
@RequestMapping("v2")
public class ControllersConsumo {
		
	private final VereadorService vereadorService;
	private final SenadorService senadorService;
	private final PresidenteService presidenteService;
	private final PrefeitoService prefeitoService;
	private final MinistroService ministroService;
	private final GovernadorService governadorService;
	private final DeputadoService deputadoService;
	private final PartidoService partidoService;

	public ControllersConsumo(VereadorService vereadorService, SenadorService senadorService,
			PresidenteService presidenteService, PrefeitoService prefeitoService, MinistroService ministroService,
			GovernadorService governadorService, DeputadoService deputadoService, PartidoService partidoService) {
		this.vereadorService = vereadorService;
		this.senadorService = senadorService;
		this.presidenteService = presidenteService;
		this.prefeitoService = prefeitoService;
		this.ministroService = ministroService;
		this.governadorService = governadorService;
		this.deputadoService = deputadoService;
		this.partidoService = partidoService;
	}

	@GetMapping("/vereadores")
	public ResponseEntity<Page<ConsultaVereadorDTO>> buscarTodosVereadores(@PageableDefault Pageable pageable){
		
		return ResponseEntity.ok(vereadorService.listarTodosOsVereadores(pageable).map(VereadorMapper::fromEntity));
	}
	
	@GetMapping("/vereadores/{id}")
	public ResponseEntity<ConsultaVereadorDTO> buscarVereador(@PathVariable Long id) {
		
		Vereador vereador = vereadorService.buscarVereador(id);
			
		return ResponseEntity.ok(VereadorMapper.fromEntity(vereador));
		
	}
	
	@GetMapping("/senadores")
	public ResponseEntity<Page<ConsultaSenadorDTO>> buscarTodosSenadores(@PageableDefault Pageable pageable){
		
		return ResponseEntity.ok(senadorService.listarTodosOsSenadores(pageable).map(SenadorMapper::fromEntity));
	}
	
	@GetMapping("/senadores/{id}")
	public ResponseEntity<ConsultaSenadorDTO> buscarSenador(@PathVariable Long id) {
		
		Senador senador = senadorService.buscarSenador(id);
			
		return ResponseEntity.ok(SenadorMapper.fromEntity(senador));
		
	}
	
	@GetMapping("/presidentes")
	public ResponseEntity<Page<ConsultaPresidenteDTO>> buscarTodosPresidentes(@PageableDefault Pageable pageable){
		
		return ResponseEntity.ok(presidenteService.listarTodosOsPresidentes(pageable).map(PresidenteMapper::fromEntity));
	}
	
	@GetMapping("/presidentes/{id}")
	public ResponseEntity<ConsultaPresidenteDTO> buscarPresidente(@PathVariable Long id) {
		
		Presidente presidente = presidenteService.buscarPresidente(id);
			
		return ResponseEntity.ok(PresidenteMapper.fromEntity(presidente));
		
	}
	
	@GetMapping("/prefeitos")
	public ResponseEntity<Page<ConsultaPrefeitoDTO>> buscarTodosPrefeitos(@PageableDefault Pageable pageable){
		
		return ResponseEntity.ok(prefeitoService.listarTodosOsPrefeitos(pageable).map(PrefeitoMapper::fromEntity));
	}
	
	@GetMapping("/prefeitos/{id}")
	public ResponseEntity<ConsultaPrefeitoDTO> buscarPrefeito(@PathVariable Long id) {
		
		Prefeito prefeito = prefeitoService.buscarPrefeito(id);
			
		return ResponseEntity.ok(PrefeitoMapper.fromEntity(prefeito));
		
	}
	
	@GetMapping("/ministros")
	public ResponseEntity<Page<ConsultaMinistroDTO>> buscarTodosMinistros(@PageableDefault Pageable pageable){
		
		return ResponseEntity.ok(ministroService.listarTodosOsMinistros(pageable).map(MinistroMapper::fromEntity));
	}
	
	@GetMapping("/ministros/{id}")
	public ResponseEntity<ConsultaMinistroDTO> buscarMinistro(@PathVariable Long id) {
		
		Ministro ministro = ministroService.buscarMinistro(id);
			
		return ResponseEntity.ok(MinistroMapper.fromEntity(ministro));
		
	}
	
	@GetMapping("/governadores")
	public ResponseEntity<Page<ConsultaGovernadorDTO>> buscarTodosGovernadores(@PageableDefault Pageable pageable){
		
		return ResponseEntity.ok(governadorService.listarTodosOsGovernadores(pageable).map(GovernadorMapper::fromEntity));
	}
	
	@GetMapping("/governadores/{id}")
	public ResponseEntity<ConsultaGovernadorDTO> buscarGovernador(@PathVariable Long id) {
		
		Governador governador = governadorService.buscarGovernador(id);
			
		return ResponseEntity.ok(GovernadorMapper.fromEntity(governador));
		
	}
	
	@GetMapping("/deputados")
	public ResponseEntity<Page<ConsultaDeputadoDTO>> buscarTodosDeputados(@PageableDefault Pageable pageable){
		
		return ResponseEntity.ok(deputadoService.listarTodosOsDeputados(pageable).map(DeputadoMapper::fromEntity));
	}
	
	@GetMapping("/deputados/{id}")
	public ResponseEntity<ConsultaDeputadoDTO> buscarDeputado(@PathVariable Long id) {
		
		Deputado deputado = deputadoService.buscarDeputado(id);
			
		return ResponseEntity.ok(DeputadoMapper.fromEntity(deputado));
		
	}
	
	@GetMapping("/partidos")
	public ResponseEntity<Page<ConsultaPartidoDTO>> buscarTodosPartidos(@PageableDefault Pageable pageable){
		
		return ResponseEntity.ok(partidoService.listarTodosOsPartidos(pageable).map(PartidoMapper::fromEntity));
	}
	
	@GetMapping("/partidos/{id}")
	public ResponseEntity<ConsultaPartidoDTO> buscarPartido(@PathVariable Long id) {
		
		Partido partido = partidoService.buscarPartido(id);
			
		return ResponseEntity.ok(PartidoMapper.fromEntity(partido));
		
	}
}
