package com.tourofheroes.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.tourofheroes.constantsandenums.CustomErrorCodeAndMessages;
import com.tourofheroes.customexception.CustomBaseException;
import com.tourofheroes.model.APIErrorResponse;
import com.tourofheroes.model.APIResponse;

@Component
public class BuildResponseUtil {

	// private constructor
	private BuildResponseUtil() {
	}

	// Build the success Response
	public static final APIResponse buildSuccessResponseObject(Object result, String message) {
		APIResponse apiResponse = new APIResponse();
		apiResponse.setMessage(message);
		apiResponse.setSuccess(true);

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		apiResponse.setTimestamp(dateFormat.format(date)); // example: 2016/11/16 12:08:43

		apiResponse.setData(result);

		return apiResponse;

	}

	// Build the Error Response
	public static final APIResponse buildErrorResponseObject(CustomBaseException customBaseException,
			String genericErrorMessage) {

		APIResponse apiResponse = new APIResponse();
		apiResponse.setMessage(genericErrorMessage); // a generic error message
		apiResponse.setSuccess(false);

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		apiResponse.setTimestamp(dateFormat.format(date)); // example: 2016/11/16 12:08:43

		APIErrorResponse<?> apiError = new APIErrorResponse<>();
		apiError.setErrorCode(customBaseException.getCustomErrorCodeAndMessages().getErrorCode());
		apiError.setErrorMessage(customBaseException.getCustomErrorCodeAndMessages().getErrorMessage());
		apiResponse.setError(apiError);

		return apiResponse;

	}

	public static final  <T> ResponseEntity<Object> buildErrorResponseObject(T errorData, CustomErrorCodeAndMessages customErrorCode) {
		APIResponse apiResponse = new APIResponse();
		apiResponse.setMessage(customErrorCode.getErrorMessage()); // a generic error message
		apiResponse.setSuccess(false);

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		apiResponse.setTimestamp(dateFormat.format(date)); // example: 2016/11/16 12:08:43

		APIErrorResponse<T> apiError = new APIErrorResponse<>();
		apiError.setErrorCode(customErrorCode.getErrorCode());
		apiError.setErrorMessage(customErrorCode.getErrorMessage());
		apiError.setErrorData(errorData);
		
		apiResponse.setError(apiError);

		return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
		
	}

}
