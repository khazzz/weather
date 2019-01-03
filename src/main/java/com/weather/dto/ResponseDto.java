package com.weather.dto;

public class ResponseDto<T> {

	private String errorMessage;
	protected T responseData;

	public ResponseDto(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	public ResponseDto(T responseData) {
		super();
		this.responseData = responseData;
	}

	public ResponseDto() {

	}

	public String toString() {
		return "<" + this.errorMessage +  " <"
				+ this.responseData + ">>";
	}

	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public T getResponseData() {
		return responseData;
	}

	public void setResponseData(T responseData) {
		this.responseData = responseData;
	}
}
