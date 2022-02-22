package com.gft.sistema_politico.services;

import java.util.Date;

import javax.security.sasl.AuthenticationException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.gft.sistema_politico.dto.auth.AutenticacaoDTO;
import com.gft.sistema_politico.dto.auth.TokenDTO;
import com.gft.sistema_politico.models.Usuario;

@Service
public class AutenticacaoService {
	
	private final AuthenticationManager authManager;
	
	public AutenticacaoService(AuthenticationManager authManager) {
		this.authManager = authManager;
	}
	
	@Value("${sistema_politico.jwt.expiration}")
	private String expiration;
	
	@Value("${sistema_politico.jwt.secret}")
	private String secret;
	
	@Value("${sistema_politico.jwt.issuer}")
	private String issuer;

	public TokenDTO autenticar(AutenticacaoDTO authForm) throws AuthenticationException{
		
		Authentication authenticate = authManager.authenticate(new UsernamePasswordAuthenticationToken(authForm.getUsuario(), authForm.getSenha()));		
		String token = gerarToken(authenticate);
				
		return new TokenDTO(token);
	}

	private Algorithm criarAlgoritmo() {
		return Algorithm.HMAC256(secret);
	}
	
	private String gerarToken(Authentication authenticate) {
		
		Usuario principal = (Usuario)authenticate.getPrincipal();
		
		Date hoje = new Date();
		Date dataExpiracao = new Date(hoje.getTime() + Long.parseLong(expiration));
		
		return JWT.create()
				.withIssuer(issuer)
				.withExpiresAt(dataExpiracao)
				.withSubject(principal.getId().toString())
				.sign(this.criarAlgoritmo());
	}
	
	public boolean verificaToken(String token) {
		try {
			if (token==null) {
				return false;
			}
			
			JWT.require(this.criarAlgoritmo()).withIssuer(issuer).build().verify(token);
			
			return true;
		} catch(JWTVerificationException exception) {
			return false;
		}
	}
	
	public Long retornarIdUsuario(String token) {
		String subject = JWT.require(this.criarAlgoritmo()).withIssuer(issuer).build().verify(token).getSubject();
		return Long.parseLong(subject);
	}
}
