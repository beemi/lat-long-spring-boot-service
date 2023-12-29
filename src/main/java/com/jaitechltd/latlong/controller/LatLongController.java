package com.jaitechltd.latlong.controller;

import com.jaitechltd.latlong.dto.response.ErrorResponseDto;
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
    @Operation(summary = "Get lat long from postcode.io", description = "Get lat long from postcode.io", tags = {"lat-long-service"}
            , operationId = "getLatLong", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ErrorResponseDto.class)))})
    public Mono<LatLongResponseDto> getLatLong(@RequestParam("postcode") final String postCode) {

        if (postCode == null || postCode.isEmpty()) {
            throw new BadRequestException(HttpStatus.BAD_REQUEST, "Invalid postcode");
        }
        return latLongService.getLatLong(postCode);
    }

    @GetMapping("/getLatLong2")
    @Operation(summary = "Get lat long from postcode.io", description = "Get lat long from postcode.io", tags = {"lat-long-service"}
            , operationId = "getLatLong", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ErrorResponseDto.class)))})
    public Mono<LatLongResponseDto> getLatLong2(@RequestParam("postcode") final String postCode) {

            if (postCode == null || postCode.isEmpty()) {
                throw new BadRequestException(HttpStatus.BAD_REQUEST, "Invalid postcode");
            }
            return latLongService.getLatLong(postCode);
    }
}

