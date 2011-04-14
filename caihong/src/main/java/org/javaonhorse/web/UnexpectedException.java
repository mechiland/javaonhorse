package org.javaonhorse.web;

public class UnexpectedException extends RuntimeException {
    public UnexpectedException(Throwable throwable) {
        super(throwable);
    }
}
