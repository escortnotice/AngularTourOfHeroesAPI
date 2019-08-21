package com.tourofheroes.customexception;

import com.tourofheroes.constantsandenums.CustomErrorCodeAndMessages;

@SuppressWarnings("serial")
public class CustomServiceException extends CustomBaseException {
	
	public CustomServiceException ( CustomErrorCodeAndMessages customErrorCodesAndMessages, Throwable cause) {
		super(customErrorCodesAndMessages, cause);
	}
	
	public CustomServiceException ( CustomErrorCodeAndMessages customErrorCodesAndMessages) {
		super(customErrorCodesAndMessages);
	}


}
