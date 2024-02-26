package com.jaitechltd.latlong.exceptions;


import com.jaitechltd.latlong.dto.response.ErrorResponseDto;
import com.jaitechltd.latlong.dto.response.SubErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
@Slf4j
public class ControllerErrorAdvice {


    @ExceptionHandler(PostcodeAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handlePostcodeAlreadyExistsException(final PostcodeAlreadyExistsException ex) {

        LOG.warn("Lat long already exists in the database for postcode: {}", ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse(List.of(ex.getMessage())));
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> handleBadRequestException(final BadRequestException ex) {
            LOG.warn("Invalid UK postcode format: {}", ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(List.of(ex.getMessage())));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleException(final Exception ex) {
        final String errMsg = "Something went wrong please try again later";

        final ErrorResponseDto errorResponseDto =
                new ErrorResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(), errMsg, "", "", List.of(new SubErrorDto(HttpStatus.INTERNAL_SERVER_ERROR.toString()
                        , ex.getMessage())));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(errorResponseDto);
    }


    public static record ErrorResponse(List<String> errors) {
    }
}
