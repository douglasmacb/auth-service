package br.gov.mg.bomdestino.auth.enums;

public enum ErrorType {
	UNAUTHORIZED("Não autorizado");

	private String value;
	
	ErrorType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
}
