package com.learnwebservices.services.tempconverter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class ConversionHistoryResponse {
	
	@XmlElementWrapper(name = "conversionhistory")
	@XmlElement(name = "conversionrequest")
    public List<RequestLogItemResponse> conversionRequestLog; 
    
    public List<RequestLogItemResponse> getConversionRequestLog() {
		return conversionRequestLog;
	}

	public void setConversionRequestLog(List<RequestLogItemResponse> requestLogItems) {
		this.conversionRequestLog = (List<RequestLogItemResponse>) requestLogItems;
	}
    
    }
