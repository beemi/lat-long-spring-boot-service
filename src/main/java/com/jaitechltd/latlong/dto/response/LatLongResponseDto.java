package com.jaitechltd.latlong.dto.response;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class LatLongResponseDto {
    private double latitude;
    private double longitude;
}
