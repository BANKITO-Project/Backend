package com.app.ControllerHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.BusinessException.BusinessException;

@ControllerAdvice
public class ControllerHandler {
	@ExceptionHandler
	@ResponseBody
	String invalidBusinessExcpetion(BusinessException exception) {
		return exception.getMessage();
	}
}
