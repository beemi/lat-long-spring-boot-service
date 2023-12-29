package com.jaitechltd.latlong;

import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class LatLongServiceApplicationTests {

	@Autowired(required = false)
	ApplicationContext applicationContext;

	@Test
	void applicationContextShouldBeInitialised() {
		assertThat(applicationContext).isNotNull();
	}
}
