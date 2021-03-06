package com.jaitechltd.latlongspringbootservice;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Slf4j
@RestController
public class LatLongController {

    private final String POSTCODE_URL = "https://api.postcodes.io/postcodes/";

    @GetMapping("/getLatLong")
    public ResponseEntity<Object> getLatLong(@RequestParam("postcode") final String postCode) {

        val responseHeaders = new HttpHeaders();
        responseHeaders.set("Content-Type", "application/json");
        responseHeaders.set("Access-Control-Allow-Origin", "*");

        if (postCode.isEmpty()) {
            log.error("Postcode is empty");
            return ResponseEntity.badRequest().body("Please provide a postcode");
        }
        var client = HttpClient.newHttpClient();
        var url = POSTCODE_URL + postCode;
        var request = HttpRequest.newBuilder(URI.create(url)).build();

        HttpResponse<String> response = null;
        Object json = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            log.info("Response: {}", response.body());
            json = response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        if (response == null || json == null) {
            log.error("Error getting lat long for postcode: " + url);
            return ResponseEntity.badRequest().body("Downstream service is not available");
        }
        return ResponseEntity.ok().headers(responseHeaders).body(json);
    }
}

