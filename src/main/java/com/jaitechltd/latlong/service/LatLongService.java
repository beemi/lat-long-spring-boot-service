package com.jaitechltd.latlong.service;

import com.jaitechltd.latlong.dto.response.LatLongResponseDto;
import com.jaitechltd.latlong.webclient.LatLongRestClient;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class LatLongService {

    LatLongRestClient latLongRestClient;

    private final ModelMapper modelMapper;

    public LatLongService(LatLongRestClient latLongRestClient, ModelMapper modelMapper) {
        this.latLongRestClient = latLongRestClient;
        this.modelMapper = modelMapper;
    }

    public Mono<LatLongResponseDto> getLatLong(String postCode) {

        return latLongRestClient.getLatLong(postCode)
                .filter(responseDto -> responseDto.getResult() != null)
                .map(responseDto -> modelMapper.map(responseDto, LatLongResponseDto.class));
    }
}
