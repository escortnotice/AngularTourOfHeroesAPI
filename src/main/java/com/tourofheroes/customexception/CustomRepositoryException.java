package com.tourofheroes.customexception;

import com.tourofheroes.constantsandenums.CustomErrorCodeAndMessages;

@SuppressWarnings("serial")
public class CustomRepositoryException  extends CustomBaseException {
	
	public CustomRepositoryException ( CustomErrorCodeAndMessages customErrorCodesAndMessages, Throwable cause) {
		super(customErrorCodesAndMessages, cause);
	}
	
	public CustomRepositoryException ( CustomErrorCodeAndMessages customErrorCodesAndMessages) {
		super(customErrorCodesAndMessages);
	}

	
}
