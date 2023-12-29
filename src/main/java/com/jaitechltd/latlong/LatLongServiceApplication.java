package com.jaitechltd.latlong;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class LatLongServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LatLongServiceApplication.class, args);
		log.info("LatLongServiceApplication started successfully");
	}
}
