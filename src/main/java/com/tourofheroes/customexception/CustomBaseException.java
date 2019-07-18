package com.tourofheroes.customexception;

@SuppressWarnings("serial")
public class CustomBaseException extends Exception {

	private String errorCustomMessage;
	private String errorCustomCode;
	
	public CustomBaseException(String customMessage) {
		super(customMessage);
		this.errorCustomMessage = customMessage;
	}

	public CustomBaseException(String customMessage, Throwable cause) {
		super(customMessage, cause);
		this.errorCustomMessage = customMessage;
	}

	//getters and setters
	public String getErrorCustomMessage() {
		return errorCustomMessage;
	}

	public void setErrorCustomMessage(String errorCustomMessage) {
		this.errorCustomMessage = errorCustomMessage;
	}

	public String getErrorCustomCode() {
		return errorCustomCode;
	}

	public void setErrorCustomCode(String errorCustomCode) {
		this.errorCustomCode = errorCustomCode;
	}

	
}
