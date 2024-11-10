package com.employee.utils;

public enum MsgCodes {

	
	/**
	 * Success codes
	 */
	success(200, "success"), 
	genericError(400,"error"),
	namenull(210, "name-null"),
	lastnamenull(211, "lastname-null"),
	doctypenull(212, "doctype-null"),
	docnumbernull(213, "docnumber-null"),
	birthdatenull(214, "birthdate-null"),
	entrancedatenull(215, "entrancedate-null"),
	rolenull(216, "role-null"),
	salarynull(217, "salary-null");
    private int code;
	
	private String languageKey;
	
	MsgCodes(int code){
		this.code = code;
	}
	
	MsgCodes(int code, String languageKey){
		this.code = code;
		this.languageKey = languageKey;
	}
	
	public Integer code() {
		return this.code;
	}

	public String getLanguageKey() {
		return languageKey;
	}

	public void setLanguageKey(String languageKey) {
		this.languageKey = languageKey;
	}

	public static MsgCodes findByCode(String strcode) {
		for (MsgCodes code : MsgCodes.values()) {
			if (code.code == Integer.valueOf(strcode)) {
				return code;
			}
		}
		return null;
	}
	
	
	
	
	
}
