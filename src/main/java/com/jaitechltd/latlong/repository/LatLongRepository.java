package com.jaitechltd.latlong.repository;

import com.jaitechltd.latlong.model.LatLongEntity;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LatLongRepository extends JpaRepository<LatLongEntity, String> {

    Optional <List<LatLongEntity>> findByPostcode(String postCode);
}
