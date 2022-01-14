package org.tutorial.jpa.tuto.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler{
	
	@org.springframework.web.bind.annotation.ExceptionHandler(value = ApplicationException.class)
	protected ResponseEntity<Response> handleExceptionInternal(ApplicationException ex) {
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("ApplicationException", ex.getMessage());
		Response response =new Response<>();
		response.setResponseData(null);
		response.setErrorDetails(map);
		response.setIsValidationFailed(true);
		
		HttpHeaders header=new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		
		return new ResponseEntity<Response>(response,header, HttpStatus.OK);
	}
	
	
}
