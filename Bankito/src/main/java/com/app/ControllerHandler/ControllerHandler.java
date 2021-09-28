package com.app.ControllerHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.app.BusinessException.BussinessException;

@ControllerAdvice
public class ControllerHandler {
    @ExceptionHandler
    @ResponseBody
    String invalidBusinessExcpetion(BussinessException exception) {
	return exception.getMessage();
}
}
