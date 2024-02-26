package com.jaitechltd.latlong.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseDto {
    private Result result;
    private int status;
}
