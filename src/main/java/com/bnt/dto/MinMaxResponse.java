package com.bnt.dto;

import java.io.Serializable;

public class MinMaxResponse implements Serializable {

	private int min;
	private int max;

	public MinMaxResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "MinMaxResponse [min=" + min + ", max=" + max + "]";
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	public MinMaxResponse(int min, int max) {
		super();
		this.min = min;
		this.max = max;
	}

}
