package com.learnwebservices.services.tempconverter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class RequestLogItem {

	@Id
	@GeneratedValue
	private Long id;
	
	private String requestType;
	private String requestDate;
	private Double input;
	private Double output;
	
	public RequestLogItem() {	
	}
	
	public RequestLogItem(Long id, String requestType, String requestDate, Double input, Double output) {
		super();
		this.id = id;
		this.requestType = requestType;
		this.requestDate = requestDate;
		this.input = input;
		this.output = output;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRequestType() {
		return requestType;
	}
	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	public Double getInput() {
		return input;
	}
	public void setInput(Double input) {
		this.input = input;
	}
	public Double getOutput() {
		return output;
	}
	public void setOutput(Double output) {
		this.output = output;
	}
	
	
}
