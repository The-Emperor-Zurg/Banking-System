package ru.TheEmperorZurg.exceptions;


public class SuspiciousClientException extends RuntimeException {
    public SuspiciousClientException(String message) {
        super(message);
    }

    public SuspiciousClientException(String message, Throwable cause) {
        super(message, cause);
    }
}