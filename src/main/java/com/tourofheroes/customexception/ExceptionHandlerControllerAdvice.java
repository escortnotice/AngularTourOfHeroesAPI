package com.tourofheroes.customexception;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tourofheroes.constantsandenums.CustomErrorCodeAndMessages;
import com.tourofheroes.model.APIResponse;
import com.tourofheroes.util.BuildResponseUtil;

@ControllerAdvice
public class ExceptionHandlerControllerAdvice extends ResponseEntityExceptionHandler{

	Logger log = LoggerFactory.getLogger(ExceptionHandlerControllerAdvice.class);

	
	//This exception is thrown when argument annotated with @Valid failed validation (validating api requests with @Valid annotation in model class)
	@Override
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<String> details = new ArrayList<>();
		for( ObjectError obj:  ex.getBindingResult().getAllErrors() ) {
			details.add(obj.getDefaultMessage());
		}
		log.error("Invalid Input Data");
		APIResponse apiResponse= BuildResponseUtil.buildErrorResponseObject(details,CustomErrorCodeAndMessages.INVALID_INPUT_DATA);
		return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
	}

	//This exception is thrown when request missing parameter
	@Override
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	protected ResponseEntity<Object> handleMissingServletRequestParameter(
	  MissingServletRequestParameterException ex, HttpHeaders headers, 
	  HttpStatus status, WebRequest request) {
		log.error("{} parameter is missing", ex.getParameterName());
		APIResponse apiResponse= BuildResponseUtil.buildErrorResponseObject(ex.getParameterName() + " parameter is missing",CustomErrorCodeAndMessages.BAD_REQUEST);
		return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
	}
	
	//If the particular HTTP Method not supported for that api request
	@Override
	@ResponseBody
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, 
			HttpHeaders headers, HttpStatus status, WebRequest request){
		log.error("{} method not supported" , ex.getMethod());
		APIResponse apiResponse=  BuildResponseUtil.buildErrorResponseObject(ex.getMethod() + " method not supported" ,CustomErrorCodeAndMessages.BAD_REQUEST);
		return new ResponseEntity<>(apiResponse, HttpStatus.METHOD_NOT_ALLOWED); 
	}
	
	
	//This exception is thrown when method argument is not the expected type:
	@ExceptionHandler({ MethodArgumentTypeMismatchException.class })
	@ResponseBody
	public ResponseEntity<Object> handleMethodArgumentTypeMismatch(
	  MethodArgumentTypeMismatchException ex, WebRequest request) {
		log.error("{} should be of type {}", ex.getName() , ex.getRequiredType().getName());
		APIResponse apiResponse= BuildResponseUtil.buildErrorResponseObject(ex.getName() + " should be of type " + ex.getRequiredType().getName(),CustomErrorCodeAndMessages.BAD_REQUEST);
		return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST); 
	}
	
	
	//handling server side custom exceptions
	@ExceptionHandler(CustomBaseException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	@ResponseBody
	public APIResponse handleException(CustomBaseException customBaseException) {

		log.error("Caught Exception in ExceptionHandlerAdvice class - HTTP ErrorCode: {}" , HttpStatus.INTERNAL_SERVER_ERROR);
		log.error("Caught Exception in ExceptionHandlerAdvice class - Custom ErrorCodeAndMessage: {}"  , 
				customBaseException.getCustomErrorCodeAndMessages().getErrorCodeAndMessage());
		
		return BuildResponseUtil.buildErrorResponseObject(customBaseException, CustomErrorCodeAndMessages.SERVER_ERROR.getErrorMessage());

	}
	
	

}
