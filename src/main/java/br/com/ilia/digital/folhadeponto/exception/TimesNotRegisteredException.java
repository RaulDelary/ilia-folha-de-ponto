package br.com.ilia.digital.folhadeponto.exception;

public class TimesNotRegisteredException extends RuntimeException {
    
    private static final long serialVersionUID = 9091763547602349671L;

    public TimesNotRegisteredException (String message) {
        super (message);
    }
}
