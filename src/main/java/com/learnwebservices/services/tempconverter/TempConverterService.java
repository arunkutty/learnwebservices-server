package com.learnwebservices.services.tempconverter;


import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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
        writeRequestHistory("Fahrenheit to Celsius", temperatureInFahrenheit, temperatureInCelsius);
        return temperatureInCelsius;
    }
    
    public Iterable<RequestLogItem> getConversionHistory(int numOfRecords) {
    	int pageSize = 5;
    	Pageable currentPage = Pageable.ofSize(pageSize);
		int pageCounter = 1; 
		List<RequestLogItem> requests = new ArrayList<RequestLogItem>();
		while (pageCounter*pageSize <= numOfRecords) {
			Iterator<RequestLogItem> requestsIter = requestLogRepository.findAll(currentPage).iterator();
			while (requestsIter.hasNext()) {
				requests.add(requestsIter.next());
			}
			if (currentPage.getPageSize() <= pageSize) {
				currentPage = currentPage.next();
				pageCounter++;
			} else {
				break;
			}	
		}
    	return requests;
    }
}
