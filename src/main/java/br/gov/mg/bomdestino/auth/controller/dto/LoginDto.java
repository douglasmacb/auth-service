package br.gov.mg.bomdestino.auth.controller.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LoginDto {
	private String token;
	private String tipo;
	private List<String> roles;
	private String email;
}
