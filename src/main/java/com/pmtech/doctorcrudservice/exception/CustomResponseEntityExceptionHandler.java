package com.pmtech.doctorcrudservice.exception;

import com.pmtech.doctorcrudservice.controller.DoctorCrudController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    Logger logger = LoggerFactory.getLogger(DoctorCrudController.class);

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage(), Arrays.asList(request.getDescription(false)));

        logger.error(exceptionResponse.toString());

        return new ResponseEntity<>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> err =  ex.getBindingResult().getFieldErrors().stream().map(e -> e.getDefaultMessage()).collect(Collectors.toList());
        ExceptionResponse exceptionResponse = new ExceptionResponse(HttpStatus.BAD_REQUEST, "Validation Failed", err);
        logger.error(exceptionResponse.toString());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(DoctorNotFoundException.class)
    public final ResponseEntity<Object> resourceNotFoundException(DoctorNotFoundException ex, WebRequest request){

        ExceptionResponse exceptionResponse = new ExceptionResponse(
                HttpStatus.NOT_FOUND,ex.getMessage(),Arrays.asList(request.getDescription(false)));
        logger.error(exceptionResponse.toString());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
