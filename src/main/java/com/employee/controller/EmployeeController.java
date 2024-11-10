package com.employee.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.employee.models.Employee;
import com.employee.services.EmployeeService;
import com.employee.utils.MsgCodes;
import com.employee.utils.OutcomeCodes;
import com.employee.utils.RequestResolver;
import com.employee.utils.RequestResponse;
import com.example.soap.EmployeeResponse;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.OPTIONS})
public class EmployeeController {
    
	@Autowired
	private EmployeeService empService;
	
	@PostMapping(value = "/save")
	public RequestResponse<EmployeeResponse> saveEmployee(@RequestBody Employee employee) {
		RequestResolver<EmployeeResponse> resolver = new RequestResolver<EmployeeResponse>();
		OutcomeCodes codes = OutcomeCodes.of(MsgCodes.success, MsgCodes.genericError);
		return resolver.processRequest(codes, () -> empService.saveEmployee(employee));
	}
}
