package com.employee.exceptions;

import java.util.Map;

import com.employee.utils.MsgCodes;


public class EmployeeException extends RuntimeException{

	
	private MsgCodes code;
	private Map<String, String> args;
	
	private static final long serialVersionUID = 1L;
	
	public EmployeeException(MsgCodes code, Map<String, String> args) {
		this.code = code;
		this.args = args;
	}

	public MsgCodes getCode() {
		return code;
	}

	public Map<String, String> getArgs() {
		return args;
	}
}
