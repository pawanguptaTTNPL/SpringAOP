package com.example.SpringAOP.exceptionhandling;

import com.example.SpringAOP.entities.ExceptionLog;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ControllerAdvice
@RestController
public class CustomizedResponseExceptionHandler
        extends ResponseEntityExceptionHandler {
    @ExceptionHandler({Exception.class,RuntimeException.class})
    public final ResponseEntity<Object>handleNotFoundExceptions(Exception ex, HttpServletRequest request) {
        ExceptionLog exceptionResponse= new ExceptionLog(ex.getMessage(),new Date(),request.getRequestURI());
        System.out.println("NOt found Exception called-->>");
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({UserNotFoundException.class})
    public final ResponseEntity<Object>handleUserNotFoundExceptions(Exception ex, HttpServletRequest request) {
        ExceptionLog exceptionResponse= new ExceptionLog(ex.getMessage(),new Date(),request.getRequestURI());
        System.out.println(" User Not found Exception Custom");
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

}