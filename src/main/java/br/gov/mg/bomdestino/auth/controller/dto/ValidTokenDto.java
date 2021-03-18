package br.gov.mg.bomdestino.auth.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ValidTokenDto {
	private String token;
	private boolean valid;	
}
