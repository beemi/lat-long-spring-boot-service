package com.jaitechltd.latlong.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class SubErrorDto {
    private String errorCode;
    private String message;
}
