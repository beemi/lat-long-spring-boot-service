package com.jaitechltd.latlongspringbootservice.exceptions;


import com.jaitechltd.latlongspringbootservice.dto.response.ErrorResponseDto;
import com.jaitechltd.latlongspringbootservice.dto.response.SubErrorDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.List;

@org.springframework.web.bind.annotation.ControllerAdvice
@Slf4j
public class ControllerAdvice {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponseDto> handleBadRequestException(final BadRequestException ex) {
        final ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                ex.getStatusCode().value(), "BAD REQUEST", "", "",
                List.of(new SubErrorDto(ex.getStatusCode().toString(), ex.getMessage())));
        return ResponseEntity.status(ex.getStatusCode().value()).body(errorResponseDto);
    }
}
