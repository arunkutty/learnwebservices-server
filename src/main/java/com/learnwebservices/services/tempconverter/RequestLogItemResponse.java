package com.learnwebservices.services.tempconverter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement (name = "conversionrequest")
public class RequestLogItemResponse {

		@XmlElement(name = "ID", required = true)
    	private Long id;
		@XmlElement(name = "RequestType", required = true)
		private String requestType;
		@XmlElement(name = "RequestDate", required = true)
		private String requestDate;
		@XmlElement(name = "Input", required = true)
		private double input;
		@XmlElement(name = "Output", required = true)
		private double output;
		
		public void setRequestLogItemResponse(Long id, String requestType, String requestDate, double input, double output) {
			this.id = id;
			this.requestType = requestType;
			this.requestDate = requestDate;
			this.input = input;
			this.output = output;
			return;
		}
    	    
    }
