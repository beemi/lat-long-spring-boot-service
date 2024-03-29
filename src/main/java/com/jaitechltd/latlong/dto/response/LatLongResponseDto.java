package com.jaitechltd.latlong.dto.response;

import lombok.*;

import java.time.Instant;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
public class LatLongResponseDto {

    private String postcode;
    private double latitude;
    private double longitude;
    private Instant timestamp;
}
