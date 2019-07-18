package com.tourofheroes.customexception;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.tourofheroes.constants.CustomErrorMessages;
import com.tourofheroes.model.APIErrorResponse;
import com.tourofheroes.model.APIResponse;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice {

	Logger logger = LoggerFactory.getLogger(ExceptionHandlerControllerAdvice.class);

	

	@ExceptionHandler(CustomBaseException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public APIResponse handleException(CustomBaseException customBaseException) {

		logger.error("Caught Exception in ExceptionHandlerAdvice class - HTTP ErrorCode:" + HttpStatus.INTERNAL_SERVER_ERROR);
		logger.error("Caught Exception in ExceptionHandlerAdvice class - Custom ErrorCode:"  + customBaseException.getErrorCustomCode());
		logger.error("Caught Exception in ExceptionHandlerAdvice class - Custom ErrorMessage:" + customBaseException.getErrorCustomMessage());
		
		return buildErrorResponseObject(customBaseException, CustomErrorMessages.INTERNAL_SERVER_ERROR_OCCURED);

	}
	
	
	/*
	 * Build the api error response object
	 */
	private APIResponse buildErrorResponseObject(CustomBaseException customBaseException, String responseMessage) {

		APIResponse apiResponse = new APIResponse();
		apiResponse.setMessage(responseMessage);
		apiResponse.setSuccess(false);

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		apiResponse.setTimestamp(dateFormat.format(date)); // ex: 2016/11/16 12:08:43

		APIErrorResponse apiError = new APIErrorResponse();
		apiError.setErrorCode(customBaseException.getErrorCustomCode());
		apiError.setErrorMessage(customBaseException.getErrorCustomMessage());
		apiResponse.setError(apiError);

		return apiResponse;

	}
}
