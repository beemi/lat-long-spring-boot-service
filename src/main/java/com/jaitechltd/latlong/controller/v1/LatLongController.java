package com.jaitechltd.latlong.controller.v1;

import com.jaitechltd.latlong.exceptions.ControllerErrorAdvice;
import com.jaitechltd.latlong.service.LatLongService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
                    content = @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ControllerErrorAdvice.ErrorResponse.class)))})
    public ResponseEntity<?> getLatLong(@RequestParam("postcode") final String postCode) {
        return ResponseEntity.ok(latLongService.getLatLong(postCode));
    }

    @GetMapping("/getLatLong2")
    @Operation(summary = "Get lat long from postcode.io", description = "Get lat long from postcode.io", tags = {"lat-long-service"}
            , operationId = "getLatLong", responses = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "OK"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @io.swagger.v3.oas.annotations.media.Content(schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ControllerErrorAdvice.ErrorResponse.class)))})
    public ResponseEntity<?> getLatLong2(@RequestParam("postcode") final String postCode) {
            return ResponseEntity.ok(latLongService.getLatLong(postCode));
    }
}

