package com.employee.soapconfig;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.employee.models.Employee;
import com.employee.repositories.EmployeeRepository;
import com.example.soap.EmployeeRequest;
import com.example.soap.EmployeeResponse;

import jakarta.transaction.Transactional;

@Endpoint
public class EmployeeEndpoint {
    

    private static final String NAMESPACE_URI = "http://example.com/soap";
    
    @Autowired
	private EmployeeRepository empRepo;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "EmployeeRequest")
    @ResponsePayload
    @Transactional
    public EmployeeResponse procesarEmpleado(@RequestPayload EmployeeRequest request) {
        EmployeeResponse response = new EmployeeResponse();
        Employee emp = new Employee();
        emp.setName(request.getName());
        emp.setLastname(request.getLastname());
        emp.setDocType(request.getDocType());
        emp.setDocNumber(request.getDocType());
        emp.setBirthDate(request.getBirthDate());
        emp.setEntranceDate(request.getEntranceDate());
        emp.setRole(request.getRole());
        emp.setSalary(request.getSalary());
        emp = empRepo.save(emp);
        response.setId(emp.getId());
        response.setName(emp.getName());
        response.setLastname(emp.getLastname());
        response.setDocType(emp.getDocType());
        response.setDocNumber(emp.getDocNumber());
        response.setBirthDate(emp.getBirthDate());
        response.setEntranceDate(emp.getEntranceDate());
        response.setRole(emp.getRole());
        response.setSalary(emp.getSalary());
        LocalDate entranceDate = emp.getEntranceDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate birthDate = emp.getBirthDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate currentDate = LocalDate.now();
        Period entranceTime = Period.between(entranceDate, currentDate);
        Period ageTime = Period.between(birthDate, currentDate);
        String entrance = entranceTime.getYears() + " years," + entranceTime.getMonths() + " months," + entranceTime.getDays() + " days";
        String age = ageTime.getYears() + " years," + ageTime.getMonths() + " months," + ageTime.getDays() + " days";
        response.setEntrance(entrance);
        response.setAge(age);
        return response;
    }
}
