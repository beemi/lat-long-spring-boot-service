package com.jaitechltd.latlongspringbootservice.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ResponseDto {
    private Result result;
    private int status;
}
