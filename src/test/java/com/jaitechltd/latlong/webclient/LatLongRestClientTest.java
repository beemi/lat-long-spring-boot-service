package com.jaitechltd.latlong.webclient;

import com.jaitechltd.latlong.dto.ResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;

class LatLongRestClientTest {

    @Mock
    private WebClient webClient;

    @Mock
    private ResponseDto mockResponse;

    private LatLongRestClient latLongRestClient;

    @Value("${postcode-io-dns}")
    private String postcodeIoDns;

    private final String postcodeIoBaseUrl = "/postcodes/";

    @BeforeEach
    public void setUp() {
        latLongRestClient = new LatLongRestClient(webClient);
    }

    @Nested
    class GetLatLong {
        @Test
        void getLatLong_SuccessfulResponse() {
            System.out.printf("postcodeIoDns: %s%n", postcodeIoDns);
        }
    }
}
