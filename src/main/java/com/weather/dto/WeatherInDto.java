package com.weather.dto;

import java.io.Serializable;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class WeatherInDto implements Serializable {
	
	// at least one character
	@NotEmpty(message="validation.city.is.not.provided")
	// up to 50 characters max
	@Size(min = 1, max = 50, message = "validation.city.must.be.between")
	// characters only
	@Pattern(regexp = "^([a-zA-Z\\u0080-\\u024F]+(?:. |-| |'))*[a-zA-Z\\u0080-\\u024F]*$",message = "validation.city.must.be.valid")
	private String city;

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
}