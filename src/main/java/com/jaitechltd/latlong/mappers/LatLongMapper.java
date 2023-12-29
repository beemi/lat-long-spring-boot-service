package com.jaitechltd.latlong.mappers;

import com.jaitechltd.latlong.dto.ResponseDto;
import com.jaitechltd.latlong.dto.response.LatLongResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.AbstractConverter;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@Slf4j
public class LatLongMapper extends AbstractConverter<ResponseDto, LatLongResponseDto> {

    private final ModelMapper modelMapper;

    public LatLongMapper(final ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    protected LatLongResponseDto convert(final ResponseDto source) {
        return new LatLongResponseDto(
                source.getResult().getPostcode(),
                source.getResult().getLatitude(),
                source.getResult().getLongitude(),
                Instant.now()
        );
    }
}
