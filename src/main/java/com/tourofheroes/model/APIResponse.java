package com.tourofheroes.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

public class APIResponse {

	private boolean success;
	private String message;
	private String timestamp;
	
	@JsonProperty("error")
	@JsonInclude(Include.NON_NULL)
	private APIErrorResponse<?> apiErrorResponse;
	
	@JsonProperty("data")
	@JsonInclude(Include.NON_NULL)
	private Object data;
	
	
	//setters and getters
	public boolean getSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public APIErrorResponse<?> getError() {
		return apiErrorResponse;
	}
	public void setError(APIErrorResponse<?> apiErrorResponse) {
		this.apiErrorResponse = apiErrorResponse;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
		
}
