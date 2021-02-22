package br.com.ilia.digital.folhadeponto.exception;

public class TimeRangeException extends RuntimeException {
	
    private static final long serialVersionUID = 1L;

    public TimeRangeException(String message) {
        super (message);
    }

    public static long getSerialversionuid () {
        return serialVersionUID;
    }
}
