package br.com.ilia.digital.folhadeponto.exception;

public class TimeAlreadyRegisteredException extends RuntimeException {
    
    private static final long serialVersionUID = -4064118539870832376L;

    public TimeAlreadyRegisteredException (String message) {
        super (message);
    }
}
