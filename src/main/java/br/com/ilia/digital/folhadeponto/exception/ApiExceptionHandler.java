package br.com.ilia.digital.folhadeponto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler (value = {AllTimesRegisteredException.class})
    public ResponseEntity <Object> handleAllTimesRegisteredException (AllTimesRegisteredException e) {
        ApiException apiException = new ApiException (e.getMessage ());

        return new ResponseEntity <Object> (apiException, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler (value = {NotFoundException.class})
    public ResponseEntity <Object> handleNotFoundException (NotFoundException e) {
        ApiException apiException = new ApiException (e.getMessage ());

        return new ResponseEntity<Object> (apiException, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler (value = {TimeAlreadyRegisteredException.class})
    public ResponseEntity <Object> handleTimeAlreadyRegisteredException (TimeAlreadyRegisteredException e) {
        ApiException apiException = new ApiException (e.getMessage ());

        return new ResponseEntity <Object> (apiException, HttpStatus.CONFLICT);
    }

    @ExceptionHandler (value = {HttpMessageNotReadableException.class})
    public ResponseEntity <Object> handleHttpMessageNotReadableException (HttpMessageNotReadableException e) {
        ApiException apiException = new ApiException ("Data e hora em formato inválido");


        return new ResponseEntity <Object> (apiException, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler (value = {TimesNotRegisteredException.class})
    public ResponseEntity <Object> handleTimesNotRegisteredException (TimesNotRegisteredException e) {
        ApiException apiException = new ApiException (e.getMessage ());

        return new ResponseEntity <Object> (apiException, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler (value = {TimeRangeException.class})
    public ResponseEntity <Object> hangleTimeRangeException (TimeRangeException e) {
        ApiException apiException = new ApiException (e.getMessage ());

        return new ResponseEntity <Object> (apiException, HttpStatus.BAD_REQUEST);
    }

}
