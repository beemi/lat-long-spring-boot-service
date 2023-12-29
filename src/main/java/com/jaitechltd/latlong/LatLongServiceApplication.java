package com.jaitechltd.latlong;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Hooks;

@SpringBootApplication
@Slf4j
public class LatLongServiceApplication {

	public static void main(String[] args) {
		Hooks.enableAutomaticContextPropagation();
		SpringApplication.run(LatLongServiceApplication.class, args);
		LOG.info("LatLongServiceApplication started successfully");
	}
}
