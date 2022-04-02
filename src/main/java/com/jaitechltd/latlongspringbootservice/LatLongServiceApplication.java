package com.jaitechltd.latlongspringbootservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class LatLongServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LatLongServiceApplication.class, args);
	}

}
