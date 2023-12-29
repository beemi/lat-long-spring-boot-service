package com.jaitechltd.latlong.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BadRequestException extends RuntimeException {

    private final HttpStatus statusCode;
    private final String message;

    public BadRequestException(final HttpStatus statusCode, final String message) {
        this.statusCode = statusCode;
        this.message = message;
    }
}
