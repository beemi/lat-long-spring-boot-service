package com.jaitechltd.latlong.service;

import com.jaitechltd.latlong.dto.ResponseDto;
import com.jaitechltd.latlong.dto.response.LatLongResponseDto;
import com.jaitechltd.latlong.exceptions.BadRequestException;
import com.jaitechltd.latlong.exceptions.PostcodeAlreadyExistsException;
import com.jaitechltd.latlong.model.LatLongEntity;
import com.jaitechltd.latlong.repository.LatLongRepository;
import com.jaitechltd.latlong.webclient.LatLongRestClient;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class LatLongService {

    private final LatLongRestClient latLongRestClient;

    private final LatLongRepository latLongRepository;

    private final ModelMapper modelMapper;

    public LatLongService(LatLongRestClient latLongRestClient, ModelMapper modelMapper, LatLongRepository latLongRepository) {
        this.latLongRestClient = latLongRestClient;
        this.modelMapper = modelMapper;
        this.latLongRepository = latLongRepository;
    }

    @Transactional
    public LatLongResponseDto getLatLong(final String postCode) {

        if (!postCode.matches("^[A-Z]{1,2}[0-9R][0-9A-Z]? [0-9][ABD-HJLNP-UW-Z]{2}$")) {
            throw new BadRequestException("Invalid UK postcode format, please enter a valid UK postcode");
        }

        Optional<List<LatLongEntity>> latLongEntityList = latLongRepository.findByPostcode(postCode);
        if (latLongEntityList.isPresent()) {
            throw new PostcodeAlreadyExistsException("Lat long already exists in the database for postcode: " + postCode);
        }

        ResponseDto responseDto = latLongRestClient.getLatLong(postCode);

        LatLongEntity latLongEntity = new LatLongEntity();
        latLongEntity.setPostcode(responseDto.getResult().getPostcode().trim());
        latLongEntity.setLatitude(responseDto.getResult().getLatitude());
        latLongEntity.setLongitude(responseDto.getResult().getLongitude());

        latLongRepository.save(latLongEntity);

        return modelMapper.map(responseDto, LatLongResponseDto.class);
    }
}
