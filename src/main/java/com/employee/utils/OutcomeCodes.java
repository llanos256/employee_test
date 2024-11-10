package com.employee.utils;

import java.util.Map;

public class OutcomeCodes {

	MsgCodes failureCode;
	
	MsgCodes successCode;

	Map<String, String> successMap;
	
	public OutcomeCodes() {
		super();
	}
	
	public static OutcomeCodes of(MsgCodes successCode, MsgCodes failureCode) {
		OutcomeCodes codes = new OutcomeCodes();
		codes.successCode = successCode;
		codes.failureCode = failureCode;
		return codes;
	}

	public Map<String, String> getSuccessMap() {
		return successMap;
	}

	public void setSuccessMap(Map<String, String> successMap) {
		this.successMap = successMap;
	}
	
	
	
}
