package com.tourofheroes.customexception;

import com.tourofheroes.constantsandenums.CustomErrorCodeAndMessages;

@SuppressWarnings("serial")
public class CustomBaseException extends Exception {

	private final CustomErrorCodeAndMessages customErrorCodeAndMessages;
	
	public CustomBaseException(CustomErrorCodeAndMessages customErrorCodeAndMessage, Throwable cause) {
		super(customErrorCodeAndMessage.getErrorCodeAndMessage(), cause);
		this.customErrorCodeAndMessages = customErrorCodeAndMessage;
	}
	
	public CustomBaseException(CustomErrorCodeAndMessages customErrorCodeAndMessage) {
		super(customErrorCodeAndMessage.getErrorCodeAndMessage());
		this.customErrorCodeAndMessages = customErrorCodeAndMessage;
	}

	//getters and setters
	public CustomErrorCodeAndMessages getCustomErrorCodeAndMessages() {
		return customErrorCodeAndMessages;
	}

	
}
