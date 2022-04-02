package com.jaitechltd.latlongspringbootservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LatLongController {

    @GetMapping("/getLatLong")
    public String getLatLong(@RequestParam("postcode") final String postCode) {

        if (postCode.isEmpty()) {
            return "Please provide a valid postcode";
        }

        return "Latitude: " + postCode + " Longitude: " + postCode;
    }
}

