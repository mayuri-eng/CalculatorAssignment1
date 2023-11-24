package com.bnt.dto;

public class CalculatorResponse {

	private Object answer;
	private String detail;

	
	public Object getAnswer() {
		return answer;
	}

	public void setAnswer(Object answer) {
		this.answer = answer;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public CalculatorResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "CalculatorResponse [answer=" + answer + ", detail=" + detail + "]";
	}

	public CalculatorResponse(Object answer, String detail) {
		super();
		this.answer = answer;
		this.detail = detail;
	}

}
