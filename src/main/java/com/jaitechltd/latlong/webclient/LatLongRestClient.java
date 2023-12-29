package com.jaitechltd.latlong.webclient;

import com.jaitechltd.latlong.dto.ResponseDto;
import com.jaitechltd.latlong.dto.response.LatLongResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class LatLongRestClient {

    private final WebClient webClient;

    @Value("${postcode-io-dns}")
    private String postcodeIoDns;

    private final String postcodeIoBaseUrl = "/postcodes/";

    public LatLongRestClient(final WebClient webClient) {
        this.webClient = webClient;
    }

    /**
     * Client to get lat long from postcode.io
     *
     * @param postCode postcode
     * @return ResponseDto
     */
    public Mono<ResponseDto> getLatLong(final String postCode) {
        var url = postcodeIoDns + postcodeIoBaseUrl + postCode;
        LOG.info("URL: {}", url);
        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(ResponseDto.class);
    }
}
