package com.employee.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.exceptions.EmployeeException;
import com.employee.models.Employee;
import com.employee.soapconfig.EmployeeClient;
import com.employee.utils.MsgCodes;
import com.example.soap.EmployeeRequest;
import com.example.soap.EmployeeResponse;

import jakarta.transaction.Transactional;

@Service
public class EmployeeService {
      	
	@Autowired
	private EmployeeClient empClient;
	
	@Transactional
	public EmployeeResponse saveEmployee(Employee employee) {
		validateEmployee(employee);
		EmployeeRequest request = new EmployeeRequest();
		request.setName(employee.getName());
		request.setLastname(employee.getLastname());
		request.setDocType(employee.getDocType());
		request.setDocNumber(employee.getDocNumber());
		request.setBirthDate(employee.getBirthDate());
		request.setEntranceDate(employee.getEntranceDate());
		request.setRole(employee.getRole());
		request.setSalary(employee.getSalary());
		return empClient.sendEmployee(request);
	}
	
	private void validateEmployee(Employee employee) {
		Double zero = 0.0;
		if (employee.getName() == null || employee.getName().isEmpty()) {
			throw new EmployeeException(MsgCodes.namenull, null);
		}

		if (employee.getLastname() == null || employee.getLastname().isEmpty()) {
			throw new EmployeeException(MsgCodes.lastnamenull, null);
		}

		if (employee.getDocType() == null || employee.getDocType().isEmpty()) {
			throw new EmployeeException(MsgCodes.doctypenull, null);
		}

		if (employee.getDocNumber() == null || employee.getDocNumber().isEmpty()) {
			throw new EmployeeException(MsgCodes.docnumbernull, null);
		}

		if (employee.getBirthDate() == null) {
			throw new EmployeeException(MsgCodes.birthdatenull, null);
		}

		if (employee.getEntranceDate() == null) {
			throw new EmployeeException(MsgCodes.entrancedatenull, null);
		}

		if (employee.getRole() == null || employee.getRole().isEmpty()) {
			throw new EmployeeException(MsgCodes.rolenull, null);
		}

		if (employee.getSalary() == null || employee.getSalary() <= zero) {
			throw new EmployeeException(MsgCodes.salarynull, null);
		}
	}
}
