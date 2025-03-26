package com.example.album.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.sql.SQLException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SQLException.class)
    public String sqlExceptionHandler (SQLException e) {  
      return e.getMessage();
    }

    @ExceptionHandler(ArtistNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String artistNotFoundExceptionHandler (ArtistNotFoundException e) {
    	System.out.println("asdadasdsaddddd ali khodast");
      return "artistNotFound";
    }
}
