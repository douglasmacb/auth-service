package br.gov.mg.bomdestino.auth.controller.dto;

public class ValidTokenDto {

	private String token;
	private boolean valid;

	public ValidTokenDto(String token, boolean valid) {
		this.token = token;
		this.valid = valid;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

}
