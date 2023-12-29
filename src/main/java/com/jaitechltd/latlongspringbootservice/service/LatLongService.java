package com.jaitechltd.latlongspringbootservice.service;

import com.jaitechltd.latlongspringbootservice.dto.ResponseDto;
import com.jaitechltd.latlongspringbootservice.webclient.LatLongRestClient;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
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
