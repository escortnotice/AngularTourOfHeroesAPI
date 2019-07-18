package com.tourofheroes.customexception;

import com.tourofheroes.constants.CustomErrorCodes;

@SuppressWarnings("serial")
public class CustomServiceException extends CustomBaseException {
	
	public CustomServiceException(String customMessage) {
		super(customMessage);
	}

	public CustomServiceException(String customMessage, Throwable cause) {
		super(customMessage , cause);
	}

	//getters and setters
	@Override
	public String getErrorCustomCode() {
		return CustomErrorCodes.BUSINESS_SERVICE_ERROR_CODE;
	}

}
