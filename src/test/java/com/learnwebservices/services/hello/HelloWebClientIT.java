package com.learnwebservices.services.hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class HelloWebClientIT {

    @Autowired
    WebTestClient webClient;

    @Test
    void testHello() {
        String request = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:hel=\"http://learnwebservices.com/services/hello\">\n" +
                "   <soapenv:Header/>\n" +
                "   <soapenv:Body>\n" +
                "      <hel:HelloRequest>\n" +
                "         <hel:Name>John Doe</hel:Name>\n" +
                "      </hel:HelloRequest>\n" +
                "   </soapenv:Body>\n" +
                "</soapenv:Envelope>";

        String response = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
                "   <soap:Body>\n" +
                "      <HelloResponse xmlns=\"http://learnwebservices.com/services/hello\">\n" +
                "         <Message>Hello John Doe!</Message>\n" +
                "      </HelloResponse>\n" +
                "   </soap:Body>\n" +
                "</soap:Envelope>";

        webClient
                .post()
                .uri("/services/hello")
                .contentType(MediaType.APPLICATION_XML)
                .header("SOAPAction", "")
                .bodyValue(request)
                .exchange()
                .expectStatus().isOk()
                .expectBody().xml(response);
    }
}
