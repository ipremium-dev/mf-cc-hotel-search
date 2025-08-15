package com.mf.hotel.search;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MainAppTests {

	@Autowired
	private YamlAppProperties ymlAppProperties;

	@Test
	void contextLoads() {
	}

	@Test
	public void whenFactoryProvidedThenYamlPropertiesInjected() {
		assertThat(ymlAppProperties.getSearchApi()).isEqualTo("https://challenge-server.tracks.run/hotel-reservation-en/hotels");
	}

}
