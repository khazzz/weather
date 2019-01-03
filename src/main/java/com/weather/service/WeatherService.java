package com.weather.service;

import java.util.Locale;

import com.weather.dto.WeatherOutDto;

public interface WeatherService {

	WeatherOutDto getData(String city, Locale locale) throws Exception;

}