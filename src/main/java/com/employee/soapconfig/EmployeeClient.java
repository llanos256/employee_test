package com.employee.soapconfig;

import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.example.soap.EmployeeRequest;
import com.example.soap.EmployeeResponse;

@Component
public class EmployeeClient extends WebServiceGatewaySupport{

    public EmployeeClient(WebServiceTemplate webServiceTemplate) {
        this.setWebServiceTemplate(webServiceTemplate);
    }
	public EmployeeResponse sendEmployee(EmployeeRequest request) {
        return (EmployeeResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws", request);
    }
}
