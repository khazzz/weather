package com.weather.service;

import java.lang.reflect.Type;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.weather.dto.WeatherOutDto;
import com.weather.vo.WeatherVO;

@Service
public class WeatherServiceImpl implements WeatherService {

	private static final Logger logger = LogManager.getLogger(WeatherServiceImpl.class);

	@Autowired
	private MessageSource messageSource;
	
	@Value("${weather.service.api.key}")
	private String weatherApiKey;

	public WeatherOutDto getData(String city, Locale locale) throws Exception {

		// make a 3rd party api call
		RestTemplate restTemplate = new RestTemplate();
		String weatherUrl = String.format(
				"http://api.openweathermap.org/data/2.5/weather?q=%s&APPID=%s", city, weatherApiKey);
		ResponseEntity<String> response = restTemplate.getForEntity(weatherUrl, String.class);

		if (response != null && response.getStatusCode().equals(HttpStatus.OK) && response.getBody() != null) {

			logger.info(response.getBody());
			
			// convert json to object
			Gson gson = new Gson();
            Type type = new TypeToken<WeatherVO>() {}.getType();
            WeatherVO weatherVO = gson.fromJson(response.getBody(), type);
            
            // collect only what we need to present
            return weatherVO.toDto();
            
		} else {
			throw new Exception(messageSource.getMessage("error.failed.to.get.weather.data", new Object[] {}, locale));
		}
	}

}