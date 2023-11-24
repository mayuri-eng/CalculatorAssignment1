package com.bnt.dto;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Calculator {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String request;
	private String response;
	private Date timestamp;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date date) {
		this.timestamp = date;
	}

	@Override
	public String toString() {
		return "Calculator [id=" + id + ", request=" + request + ", response=" + response + ", timestamp=" + timestamp
				+ "]";
	}

	public Calculator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Calculator(Long id, String request, String response, Date timestamp) {
		super();
		this.id = id;
		this.request = request;
		this.response = response;
		this.timestamp = timestamp;
	}

	

}
