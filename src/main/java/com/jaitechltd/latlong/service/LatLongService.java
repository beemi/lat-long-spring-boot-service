package com.jaitechltd.latlong.service;

import com.jaitechltd.latlong.dto.ResponseDto;
import com.jaitechltd.latlong.webclient.LatLongRestClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LatLongService {

    LatLongRestClient latLongRestClient;

    public LatLongService(LatLongRestClient latLongRestClient) {
        this.latLongRestClient = latLongRestClient;
    }

    public ResponseDto getLatLong(String postCode) {
        return latLongRestClient.getLatLong(postCode).block();
    }
}
