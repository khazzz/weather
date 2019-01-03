package com.weather;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.weather.dto.ResponseDto;
import com.weather.dto.WeatherInDto;
import com.weather.dto.WeatherOutDto;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class WeatherTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void testWeatherForMiami() {

		ResponseEntity<ResponseDto<WeatherOutDto>> result = restTemplate.exchange("/weather/?city=miami",
				HttpMethod.POST, null, new ParameterizedTypeReference<ResponseDto<WeatherOutDto>>() {
				});

		// Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertNotNull(result.getBody().getResponseData());
	}

	@Test
	public void testNoCityProvided() {

		ResponseEntity<ResponseDto<WeatherOutDto>> result = restTemplate.exchange("/weather/?city=", HttpMethod.POST,
				null, new ParameterizedTypeReference<ResponseDto<WeatherOutDto>>() {
				});

		// Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertNotNull(result.getBody().getErrorMessage());
	}
	
	@Test
	public void testCityNotExists() {

		ResponseEntity<ResponseDto<WeatherOutDto>> result = restTemplate.exchange("/weather/?city=hello", HttpMethod.POST,
				null, new ParameterizedTypeReference<ResponseDto<WeatherOutDto>>() {
				});

		// Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertNotNull(result.getBody().getErrorMessage());
	}

	@Test
	public void testBadCityProvided() {

		ResponseEntity<ResponseDto<WeatherOutDto>> result = restTemplate.exchange("/weather/?city=hello123",
				HttpMethod.POST, null, new ParameterizedTypeReference<ResponseDto<WeatherOutDto>>() {
				});

		// Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertNotNull(result.getBody().getErrorMessage());
	}

	@Test
	public void testTooLongCityProvided() {

		ResponseEntity<ResponseDto<WeatherOutDto>> result = restTemplate.exchange(
				"/weather/?city=miamimiamimiamimiamimiamimiamimiamimiamimiamimiamimiamimiamimiamimiamimiamimiamimiamimiamimiamimiamimiami",
				HttpMethod.POST, null, new ParameterizedTypeReference<ResponseDto<WeatherOutDto>>() {
				});

		// Verify request succeed
		Assert.assertEquals(200, result.getStatusCodeValue());
		Assert.assertNotNull(result.getBody().getErrorMessage());
	}
}
