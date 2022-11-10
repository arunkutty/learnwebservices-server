package com.learnwebservices.services.tempconverter;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TempConverterService {
	
	@Autowired
	private RequestLogRepository requestLogRepository;
	
	private void writeRequestHistory(String requestType, Double input, Double output) {
		RequestLogItem requestLogItem = new RequestLogItem();
		requestLogItem.setRequestType(requestType);
		requestLogItem.setRequestDate(new Date().toString());
		requestLogItem.setInput(input);
		requestLogItem.setOutput(output);
		requestLogRepository.save(requestLogItem);
	}

	public double convertCelsiusToFahrenheit(double temperatureInCelsius) {
        double temperatureInFahrenheit = temperatureInCelsius *  9 / 5.0  + 32;
        writeRequestHistory("Celsius to Fahrenheit", temperatureInCelsius, temperatureInFahrenheit);
    	return temperatureInFahrenheit;
    }

    public double convertFahrenheitToCelsius(double temperatureInFahrenheit) {
    	double temperatureInCelsius = (temperatureInFahrenheit - 32) / (9 / 5.0);
        writeRequestHistory("Celsius to Fahrenheit", temperatureInFahrenheit, temperatureInCelsius);
        return temperatureInCelsius;
    }
    
    public Iterable<RequestLogItem> getConversionHistory(double hello) {
    	return requestLogRepository.findAll();
    }
}
