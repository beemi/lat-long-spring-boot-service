package com.jaitechltd.latlongspringbootservice.dto.response;

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
