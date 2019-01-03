package com.weather.dto;

public class WeatherOutDto {

	private String description;
	private String temp;
	private String pressure;
	private String humidity;
	private String temp_min;
	private String temp_max;
	private String visibility;
	
	public WeatherOutDto() {

	}

	public WeatherOutDto(String description, String temp, String pressure, String humidity, String temp_min,
			String temp_max, String visibility) {
		this.description = description;
		this.temp = temp;
		this.pressure = pressure;
		this.humidity = humidity;
		this.temp_min = temp_min;
		this.temp_max = temp_max;
		this.visibility = visibility;
	}

	public String getDescription() {
		return description;
	}

	public String getTemp() {
		return temp;
	}

	public String getPressure() {
		return pressure;
	}

	public String getHumidity() {
		return humidity;
	}

	public String getTemp_min() {
		return temp_min;
	}

	public String getTemp_max() {
		return temp_max;
	}

	public String getVisibility() {
		return visibility;
	}
}
