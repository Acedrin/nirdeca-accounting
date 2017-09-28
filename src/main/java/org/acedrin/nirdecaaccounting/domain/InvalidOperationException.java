package org.acedrin.nirdecaaccounting.domain;

public class InvalidOperationException extends RuntimeException {
    public InvalidOperationException(String message) {
        super(message);
    }
}
