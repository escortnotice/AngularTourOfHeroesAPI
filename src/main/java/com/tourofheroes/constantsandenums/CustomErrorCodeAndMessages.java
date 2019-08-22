package com.tourofheroes.constantsandenums;

public enum CustomErrorCodeAndMessages {
	

	//Database Errors (1XXX)
	QUERY_ERROR(1200, "Query Error"),
	DATABASE_ERROR(1000, "Database Error Occured"),
	DB_UNAVAILABLE_ERROR(1300, "DB is Not Available"),

	//Business Service Errors (2XXX)
	INVALID_INPUT_DATA(2001, "Invalid Input Data"),

	//API Error Messages (4XXX)
	BAD_REQUEST(4000, "Bad Request"),
	NOT_FOUND(4040, "Not found"),
	
	//Generic Backend Error (5XXX)
	SERVER_ERROR(5000, "Error Occured At Server");
	

	private final int errorCode;
	private final String errorMessage;

	private CustomErrorCodeAndMessages(int errorCode, String errorMessage) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}
	
	public String getErrorCodeAndMessage() {
		return errorCode + " " + errorMessage;
	}

}
