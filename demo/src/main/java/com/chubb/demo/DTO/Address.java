package com.chubb.demo.DTO;

import jakarta.validation.constraints.NotBlank;

public class Address {
	@NotBlank
	public String house;
	
	@NotBlank
	public String pin;
	
	public String getHouse() {
		return house;
	}
	public void setHouse(String house) {
		this.house = house;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	
}
