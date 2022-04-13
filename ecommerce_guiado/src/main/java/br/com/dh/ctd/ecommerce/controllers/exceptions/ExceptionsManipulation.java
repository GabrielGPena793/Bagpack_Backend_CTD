package br.com.dh.ctd.ecommerce.controllers.exceptions;

import br.com.dh.ctd.ecommerce.service.exceptions.BDException;
import br.com.dh.ctd.ecommerce.service.exceptions.SourceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ExceptionsManipulation {

    @ExceptionHandler(SourceNotFound.class)
    public ResponseEntity<ErrorDefault> entityNotFound(SourceNotFound e, HttpServletRequest request){
        ErrorDefault er = new ErrorDefault();
        er.setTimestamp(Instant.now());
        er.setStatus(HttpStatus.NOT_FOUND.value());
        er.setError("Resource not found");
        er.setMessage(e.getMessage());
        er.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(er);
    }


    @ExceptionHandler(BDException.class)
    public ResponseEntity<ErrorDefault> dataBaseError(BDException e, HttpServletRequest request){
        ErrorDefault er = new ErrorDefault();
        er.setTimestamp(Instant.now());
        er.setStatus(HttpStatus.BAD_REQUEST.value());
        er.setError("Resource not found");
        er.setMessage(e.getMessage());
        er.setPath(request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
    }


}
