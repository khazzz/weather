package com.weather.vo;

import com.weather.dto.WeatherOutDto;

public class WeatherVO {

	private Weather[] weather;
	private Main main;
	private String visibility;
	private Wind wind;
	
	public WeatherOutDto toDto() {
		WeatherOutDto weatherOutDto = null;
		
		if(weather != null && weather.length == 1 && main != null) {
			weatherOutDto = new WeatherOutDto(weather[0].getDescription(), main.getTemp(), main.getPressure(), main.getHumidity(), main.getTemp_min(), main.getTemp_max(), visibility);
		}
		
		return weatherOutDto;
	}
	
	public Weather[] getWeather() {
		return weather;
	}
	public void setWeather(Weather[] weather) {
		this.weather = weather;
	}
	public Main getMain() {
		return main;
	}
	public void setMain(Main main) {
		this.main = main;
	}
	public String getVisibility() {
		return visibility;
	}
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}
	public Wind getWind() {
		return wind;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}
}
