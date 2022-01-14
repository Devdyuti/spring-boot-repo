package org.tutorial.jpa.tuto.exception;

import java.util.Map;

public class Response<T> {
	private int formErrorCount;
	private T responseData;
	private Map<String, Object> errorDetails;
	private Boolean isValidationFailed;
	
	public int getFormErrorCount() {
		return formErrorCount;
	}
	public void setFormErrorCount(int formErrorCount) {
		this.formErrorCount = formErrorCount;
	}
	public T getResponseData() {
		return responseData;
	}
	public void setResponseData(T responseData) {
		this.responseData = responseData;
	}
	public Map<String, Object> getErrorDetails() {
		return errorDetails;
	}
	public void setErrorDetails(Map<String, Object> errorDetails) {
		this.errorDetails = errorDetails;
	}
	public Boolean getIsValidationFailed() {
		return isValidationFailed;
	}
	public void setIsValidationFailed(Boolean isValidationFailed) {
		this.isValidationFailed = isValidationFailed;
	}
	
	
	
}
