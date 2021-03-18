package br.gov.mg.bomdestino.auth.validation;

public class ValidationErrorDto {

	private String message;
	private String field;

	public ValidationErrorDto(String field, String message) {
		super();
		this.field = field;
		this.message = message;
	}

	public String getField() {
		return field;
	}

	public String getMessage() {
		return message;
	}
}