package com.learnwebservices.services.tempconverter;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.jws.WebService;

@Service
@WebService(targetNamespace = "http://learnwebservices.com/services/tempconverter",
        serviceName = "TempConverterEndpointService", portName = "TempConverterEndpointPort")
public class DelegatingTempConverterEndpoint implements TempConverterEndpoint {

    private TempConverterService tempConverterService;

    public DelegatingTempConverterEndpoint(TempConverterService tempConverterService) {
        this.tempConverterService = tempConverterService;
    }

    public CelsiusToFahrenheitResponse convertToFahrenheit(CelsiusToFahrenheitRequest request) {
        double temperatureInCelsius = request.getTemperatureInCelsius();
        double temperatureInFahrenheit = tempConverterService.convertCelsiusToFahrenheit(temperatureInCelsius);
        return new CelsiusToFahrenheitResponse(temperatureInFahrenheit);
    }


    public FahrenheitToCelsiusResponse convertToCelsius(FahrenheitToCelsiusRequest request) {
        double temperatureInFahrenheit = request.getTemperatureInFahrenheit();
        double temperatureInCelsius = tempConverterService.convertFahrenheitToCelsius(temperatureInFahrenheit);
        return new FahrenheitToCelsiusResponse(temperatureInCelsius);
    }
    
    public ConversionHistoryResponse conversionHistory(ConversionHistoryRequest request) {
        double hello = request.getHello();
    	ConversionHistoryResponse requestLogResponse = new ConversionHistoryResponse();
        Iterator<RequestLogItem> items = tempConverterService.getConversionHistory(hello).iterator();
    	List <RequestLogItemResponse> requestLogItems = new ArrayList <RequestLogItemResponse>();
    	while (items.hasNext()) {
    		RequestLogItem currItem = items.next();
    		
    		RequestLogItemResponse itemForResponse = new RequestLogItemResponse();
    		itemForResponse.setRequestLogItemResponse(currItem.getId(),
    						currItem.getRequestType(),
    						currItem.getRequestDate(),
    						currItem.getInput(),
    						currItem.getOutput());
    		requestLogItems.add(itemForResponse);
    	}
    	System.out.println("RequestLogItems = " + requestLogItems);
    			
    	requestLogResponse.setConversionRequestLog(requestLogItems);
    	return requestLogResponse;
    }
}
