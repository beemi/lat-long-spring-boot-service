package com.jaitechltd.latlong.dto.response;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class ErrorResponseDto {
    private int statusCode;
    private String message;
    private String traceId;
    private String correlationId;
    private List<SubErrorDto> subMessages;
}
