package com.chubb.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(exception = Exception.class)
	public Map<String,String> handlerException(MethodArgumentNotValidException exception) {
		Map<String,String> map = new HashMap<>();
		List<ObjectError> allErrors = exception.getBindingResult().getAllErrors();
		allErrors.stream().forEach(error->{
			String feildName = ((FieldError)error).getField();
			String message = error.getDefaultMessage();
			map.put(feildName, message);
		});
		return map;
	}
}
