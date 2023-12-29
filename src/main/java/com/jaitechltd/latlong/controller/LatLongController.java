package com.jaitechltd.latlong.controller;

import com.jaitechltd.latlong.dto.ResponseDto;
import com.jaitechltd.latlong.exceptions.BadRequestException;
import com.jaitechltd.latlong.service.LatLongService;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/api")
public class LatLongController {


    LatLongService latLongService;

    public LatLongController(final LatLongService latLongService) {
        this.latLongService = latLongService;
    }

    @GetMapping("/getLatLong")
    public ResponseEntity<ResponseDto> getLatLong(@RequestParam("postcode") final String postCode) {

        val responseDto = latLongService.getLatLong(postCode);
        if (responseDto == null) {
            throw new BadRequestException(HttpStatus.BAD_REQUEST, "Invalid postcode");
        }
        return ResponseEntity.ok(responseDto);
    }
}

