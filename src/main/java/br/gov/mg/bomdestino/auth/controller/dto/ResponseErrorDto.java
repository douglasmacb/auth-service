package br.gov.mg.bomdestino.auth.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseErrorDto {
	private String error;
	private int httpStatusCode;
}
