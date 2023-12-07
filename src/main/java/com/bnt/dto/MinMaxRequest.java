package com.bnt.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MinMaxRequest{

	@JsonProperty("numbers")
	int[] numbers;

	
	public int[] getNumbers() {
		return numbers;
	}


	public void setNumbers(int[] numbers) {
		this.numbers = numbers;
	}


	@Override
	public String toString() {
		return "MinMaxRequest [numbers=" + numbers + "]";
	}


	public MinMaxRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MinMaxRequest(int[] numbers) {
		super();
		this.numbers = numbers;
	}

	

}
