package com.jaitechltd.latlong.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ServiceDownException extends RuntimeException {

    private final HttpStatus statusCode;
    private final String message;

    public ServiceDownException(final HttpStatus statusCode, final String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
