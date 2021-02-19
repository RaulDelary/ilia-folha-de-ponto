package br.com.ilia.digital.folhadeponto.exception;

public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = -7294331620275958369L;

    public NotFoundException (String message) {
        super (message);
    }

    public static long getSerialversionuid () {
        return serialVersionUID;
    }
    
}
