package com.weather.controller;

import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.weather.dto.ResponseDto;
import com.weather.dto.WeatherInDto;
import com.weather.dto.WeatherOutDto;
import com.weather.service.WeatherService;

@Controller
@RequestMapping(value = "/weather")
public class WeatherController {

	final static Logger logger = LogManager.getLogger(WeatherController.class);

	@Autowired
	private WeatherService weatherService;

	@Autowired
	private MessageSource messageSource;

	@GetMapping("/")
	public String view() {

		return "weather";
	}

	@PostMapping("/")
	public ResponseEntity<ResponseDto<WeatherOutDto>> getWeather(Locale locale, @Valid final WeatherInDto weatherInDto,
			BindingResult bindingResult) {

		try {

			// validate input
			List<FieldError> errors = bindingResult.getFieldErrors();
			for (FieldError error : errors) {
				throw new Exception(messageSource.getMessage(error.getDefaultMessage(), new Object[] {}, locale));
			}

			// fetch data
			WeatherOutDto weatherOutDto = weatherService.getData(weatherInDto.getCity(), locale);

			// return only data on success
			return new ResponseEntity<>(new ResponseDto(weatherOutDto), HttpStatus.OK);

		} catch (Throwable e) {

			logger.error(e);

			// return only an error message on failure
			return new ResponseEntity<>(new ResponseDto(e.getMessage()), HttpStatus.OK);

		}
	}

}