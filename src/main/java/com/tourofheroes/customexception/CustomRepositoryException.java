package com.tourofheroes.customexception;

import com.tourofheroes.constants.CustomErrorCodes;

@SuppressWarnings("serial")
public class CustomRepositoryException  extends CustomBaseException {
	
	public CustomRepositoryException(String customMessage) {
		super(customMessage);
	}

	public CustomRepositoryException (String customMessage, Throwable cause) {
		super(customMessage , cause);
	}

	//getters and setters
	@Override
	public String getErrorCustomCode() {
		return CustomErrorCodes.REPOSITORY_ERROR_CODE;
	}
	
}
