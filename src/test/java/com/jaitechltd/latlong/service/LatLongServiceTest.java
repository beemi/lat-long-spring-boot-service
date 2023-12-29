package com.jaitechltd.latlong.service;

import com.jaitechltd.latlong.dto.ResponseDto;
import com.jaitechltd.latlong.dto.Result;
import com.jaitechltd.latlong.dto.response.LatLongResponseDto;
import com.jaitechltd.latlong.webclient.LatLongRestClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class LatLongServiceTest {

    @Mock
    private LatLongRestClient latLongRestClientMock;
    @Mock
    private ModelMapper modelMapperMock;
    private LatLongService latLongService;

    @BeforeEach
    public void setUp() {
        latLongService = new LatLongService(latLongRestClientMock, modelMapperMock);
    }

    @Test
    void getLatLong_SuccessfulResponse() {
        String postCode = "12345";
        ResponseDto mockResponseDto = new ResponseDto();
        mockResponseDto.setResult(new Result());

        LatLongResponseDto mockLatLongResponseDto = new LatLongResponseDto();

        when(latLongRestClientMock.getLatLong(postCode)).thenReturn(Mono.just(mockResponseDto));
        when(modelMapperMock.map(mockResponseDto, LatLongResponseDto.class)).thenReturn(mockLatLongResponseDto);

        StepVerifier.create(latLongService.getLatLong(postCode))
                .expectNext(mockLatLongResponseDto)
                .verifyComplete();
    }

    @Test
    void getLatLong_Error() {
        String postCode = "12345";
        RuntimeException exception = new RuntimeException("Error");

        when(latLongRestClientMock.getLatLong(postCode)).thenReturn(Mono.error(exception));

        StepVerifier.create(latLongService.getLatLong(postCode))
                .expectErrorMatches(throwable -> throwable instanceof RuntimeException && throwable.getMessage().equals("Error"))
                .verify();
    }


    @Test
    void getLatLong_NoResult() {
        String postCode = "12345";
        ResponseDto mockResponseDto = new ResponseDto();

        when(latLongRestClientMock.getLatLong(postCode)).thenReturn(Mono.just(mockResponseDto));

        StepVerifier.create(latLongService.getLatLong(postCode))
                .verifyComplete();
    }

    @Test
    void getLatLong_NoResponse() {
        String postCode = "12345";

        when(latLongRestClientMock.getLatLong(postCode)).thenReturn(Mono.empty());

        StepVerifier.create(latLongService.getLatLong(postCode))
                .verifyComplete();
    }


    @Test
void getLatLong_NullResponse() {
        String postCode = "12345";

        when(latLongRestClientMock.getLatLong(postCode)).thenReturn(Mono.just(new ResponseDto()));

        StepVerifier.create(latLongService.getLatLong(postCode))
                .verifyComplete();
    }

    @Test
    void getLatLong_NullResult() {
        String postCode = "12345";
        ResponseDto mockResponseDto = new ResponseDto();
        mockResponseDto.setResult(null);

        when(latLongRestClientMock.getLatLong(postCode)).thenReturn(Mono.just(mockResponseDto));

        StepVerifier.create(latLongService.getLatLong(postCode))
                .verifyComplete();
    }
}
