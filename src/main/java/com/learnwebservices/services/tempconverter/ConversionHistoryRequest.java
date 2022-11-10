package com.learnwebservices.services.tempconverter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@Data
@XmlAccessorType(XmlAccessType.FIELD)
@NoArgsConstructor
@AllArgsConstructor
public class ConversionHistoryRequest {

    public int getNumOfRecords() {
		return numOfRecords;
	}

	@XmlElement(name = "numOfRecords", required = true)
    private int numOfRecords;

}
