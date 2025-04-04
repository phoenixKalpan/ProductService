package org.phoenix13.productservice25.services;

import org.phoenix13.productservice25.exception.NotFoundException;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class exceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException e)
    {
        ErrorResponse errorResponse=new ErrorResponse() {
            @Override
            public HttpStatusCode getStatusCode() {
                return NOT_FOUND;
            }

            @Override
            public ProblemDetail getBody() {

                return null;
            }
        };
        return ResponseEntity.ok(errorResponse);
    }
}
