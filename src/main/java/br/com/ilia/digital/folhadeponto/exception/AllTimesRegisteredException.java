package br.com.ilia.digital.folhadeponto.exception;

public class AllTimesRegisteredException extends RuntimeException {
    
    private static final long serialVersionUID = 4809012565048986826L;

    public AllTimesRegisteredException (String message) {
        super (message);
    }
    
}
