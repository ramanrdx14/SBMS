package org.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;
@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(value = Exception.class)
    public ResponseEntity<AppException> handleException(Exception exception){
        AppException appException = new AppException();
        appException.setExceptionName(exception.getClass().getName());
        appException.setMsg(exception.getMessage());
        appException.setExceptionTime(LocalDate.now());
        return new ResponseEntity<>(appException, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
