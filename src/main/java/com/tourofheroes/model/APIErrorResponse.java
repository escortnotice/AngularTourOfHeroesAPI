package com.tourofheroes.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class APIErrorResponse {
	
	@JsonProperty("error-message")
	private String errorMessage;
	
	@JsonProperty("error-code")
	private String errorCode;
	
	//getters and setters
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	
	@Override
	public String toString() {
		return "APIErrorResponse [errorMessage=" + errorMessage + ", errorCode=" + errorCode + "]";
	}
	
	
	
	
}
