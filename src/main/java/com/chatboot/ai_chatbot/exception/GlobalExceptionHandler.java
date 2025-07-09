package com.chatboot.ai_chatbot.exception;

import org.springframework.ai.retry.NonTransientAiException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(NonTransientAiException.class)
	public ResponseEntity<String> handleAiException(NonTransientAiException ex, WebRequest request){
		 return ResponseEntity
		            .status(HttpStatus.TOO_MANY_REQUESTS)
		            .body("AI Error: " + ex.getMessage());
	}

}
