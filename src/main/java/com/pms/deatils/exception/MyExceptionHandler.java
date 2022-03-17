package com.pms.deatils.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {

	 @ExceptionHandler(PatientNotFoundException.class)
	    private ResponseEntity<ErrorResponse> handlePatientNotFoundException() {
	        System.out.println("*******PatientNotFoundException********");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(404,"Patient Not Found"));
	    }
	 
}
