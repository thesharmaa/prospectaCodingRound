package com.prospecta.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ClientException.class)
	public ResponseEntity<MyErrorDetails> loginException(ClientException e, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setDescription(req.getDescription(false));
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> normalException(Exception e, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setDescription(req.getDescription(false));
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> noHandleException(NoHandlerFoundException e, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setDescription(req.getDescription(false));
		err.setTimestamp(LocalDateTime.now());
		err.setMessage(e.getMessage());
		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> myMNVEHandler(MethodArgumentNotValidException me) {

		MyErrorDetails err = new MyErrorDetails();
		err.setTimestamp(LocalDateTime.now());
		err.setMessage("Validation Error");
		err.setDescription(me.getBindingResult().getFieldError().getDefaultMessage());

		return new ResponseEntity<MyErrorDetails>(err, HttpStatus.BAD_REQUEST);

	}

}
