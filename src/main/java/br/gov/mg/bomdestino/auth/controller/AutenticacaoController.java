package br.gov.mg.bomdestino.auth.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.mg.bomdestino.auth.controller.dto.LoginDto;
import br.gov.mg.bomdestino.auth.controller.dto.ResponseErrorDto;
import br.gov.mg.bomdestino.auth.controller.dto.ValidTokenDto;
import br.gov.mg.bomdestino.auth.controller.form.LoginForm;
import br.gov.mg.bomdestino.auth.enums.ErrorType;
import br.gov.mg.bomdestino.auth.security.TokenService;

@RestController
@RequestMapping("/auth")
public class AutenticacaoController {
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private TokenService tokenService;
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<?> autenticar(@RequestBody @Valid LoginForm form) {
		UsernamePasswordAuthenticationToken dadosLogin = form.converter();
 		
		try {
			Authentication authentication = authManager.authenticate(dadosLogin);
			String token = tokenService.gerarToken(authentication);
			List<String> roles = obterRegras(authentication);
			return ResponseEntity.ok(new LoginDto(token, "Bearer", roles, dadosLogin.getName()));
		} catch (AuthenticationException e) {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ResponseErrorDto(ErrorType.UNAUTHORIZED.getValue(), HttpStatus.UNAUTHORIZED.value()));
		}
	}
	
	@GetMapping("/token/validate/{token}")
	public ResponseEntity<ValidTokenDto> validarToken(@PathVariable String token) {
		boolean isTokenValido = tokenService.isTokenValido(token);
		return isTokenValido ? 
				  ResponseEntity.ok(new ValidTokenDto(token, true))
				: ResponseEntity.ok(new ValidTokenDto(token, false));
	}
	
	private List<String> obterRegras(Authentication authentication) {
		List<String> authorities = new ArrayList<String>(authentication.getAuthorities().size());
		
		for (GrantedAuthority authority : authentication.getAuthorities()) {
			authorities.add(authority.getAuthority());
		}
		return authorities;
	}
	
}
