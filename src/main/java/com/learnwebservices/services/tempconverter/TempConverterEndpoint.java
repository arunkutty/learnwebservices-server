package com.learnwebservices.services.tempconverter;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlElement;

@WebService(targetNamespace = "http://learnwebservices.com/services/tempconverter")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface TempConverterEndpoint {

    @WebMethod(operationName = "CelsiusToFahrenheit")
    @WebResult(name = "CelsiusToFahrenheitResponse")
    @XmlElement(required = true)
    CelsiusToFahrenheitResponse convertToFahrenheit(@WebParam(name = "CelsiusToFahrenheitRequest") @XmlElement(required = true)CelsiusToFahrenheitRequest request);


    @WebMethod(operationName = "FahrenheitToCelsius")
    @WebResult(name = "FahrenheitToCelsiusResponse")
    @XmlElement(required = true)
    FahrenheitToCelsiusResponse convertToCelsius(@WebParam(name = "FahrenheitToCelsiusRequest") @XmlElement(required = true)FahrenheitToCelsiusRequest request);
    
    @WebMethod(operationName = "ConversionHistory")
    @WebResult(name = "ConversionHistoryResponse")
    @XmlElement(required = true)
    ConversionHistoryResponse conversionHistory(@WebParam(name = "ConversionHistoryRequest") @XmlElement(required = true)ConversionHistoryRequest request);

}
