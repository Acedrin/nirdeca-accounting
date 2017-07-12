package org.acedrin.nirdecaaccounting.domain;

public class InvalidUserException extends RuntimeException {
    public InvalidUserException(String message) {
        super(message);
    }
}
