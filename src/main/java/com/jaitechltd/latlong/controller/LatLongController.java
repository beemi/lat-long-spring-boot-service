package com.jaitechltd.latlong.controller;

import com.jaitechltd.latlong.dto.response.LatLongResponseDto;
import com.jaitechltd.latlong.exceptions.BadRequestException;
import com.jaitechltd.latlong.service.LatLongService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/v1/api")
public class LatLongController {

    private final LatLongService latLongService;

    public LatLongController(final LatLongService latLongService) {
        this.latLongService = latLongService;
    }

    @GetMapping("/getLatLong")
    @Operation(summary = "Get lat long from postcode.io")
    public Mono<LatLongResponseDto> getLatLong(@RequestParam("postcode") final String postCode) {

        final var responseDto = latLongService.getLatLong(postCode);
        if (responseDto == null) {
            throw new BadRequestException(HttpStatus.BAD_REQUEST, "Invalid postcode");
        }
        return responseDto;
    }
}

