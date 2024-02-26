//package com.jaitechltd.latlong.webclient;
//
//import com.jaitechltd.latlong.dto.ResponseDto;
//import com.jaitechltd.latlong.dto.response.LatLongResponseDto;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Nested;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.web.reactive.function.client.WebClient;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//class LatLongRestClientTest {
//
//    @Mock
//    private WebClient webClientMock;
//
//    @Mock
//    private WebClient.RequestHeadersUriSpec webClient;
//
//    @SuppressWarnings("rawtypes")
//    @Mock
//    private WebClient.RequestHeadersSpec requestHeadersSpecMock;
//
//    @SuppressWarnings("rawtypes")
//    @Mock
//    private WebClient.RequestHeadersUriSpec requestHeadersUriSpecMock;
//
//    @SuppressWarnings("rawtypes")
//    @Mock
//    private WebClient.RequestBodyUriSpec requestBodyUriSpecMock;
//
//    @SuppressWarnings("rawtypes")
//    @Mock
//    private WebClient.RequestBodySpec requestBodySpecMock;
//
//    @SuppressWarnings("rawtypes")
//    @Mock
//    private WebClient.ResponseSpec responseSpecMock;
//
//    private LatLongRestClient latLongRestClient;
//
//    @Value("${postcode-io-dns}")
//    private String postcodeIoDns;
//
//    private final String postcodeIoBaseUrl = "/postcodes/";
//
//    @BeforeEach
//    public void setUp() {
//        latLongRestClient = new LatLongRestClient(webClientMock);
//    }
//
//    @Nested
//    class GetLatLong {
//        @Test
//        void getLatLong_SuccessfulResponse() {
//            ResponseDto responseDto = new ResponseDto();
//            String postCode = "12345";
//            String url = postcodeIoDns + postcodeIoBaseUrl + postCode;
//
//            when(webClientMock.get()).thenReturn(requestHeadersUriSpecMock);
//            when(requestHeadersUriSpecMock.uri(url)).thenReturn(requestHeadersSpecMock);
//            when(requestHeadersSpecMock.retrieve()).thenReturn(responseSpecMock);
//            when(responseSpecMock.onStatus(any(), any())).thenReturn(responseSpecMock);
//        }
//    }
//}
