package com.employee.utils;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.springframework.stereotype.Component;
import org.stringtemplate.v4.ST;

@Component
public class MessageTextResolver {

	private static final String DEFAULT_LANG = "en";
	
	public String getMessage(MsgCodes code) {
		return getMessage(code, DEFAULT_LANG);
	}
	
	
	public String getMessage(MsgCodes code,  String preferedLanguage) {
		return getMessage(code, null, preferedLanguage);
	}
	
	public String getMessage(MsgCodes code, Map<String, String> messageAttributes) {
		return getMessage(code, messageAttributes, DEFAULT_LANG);
	}
	
	public String getMessage(MsgCodes code, Map<String, String> messageAttributes,  String preferedLanguage) {
		Locale locale = Locale.of(preferedLanguage);
		ResourceBundle messageBundle = ResourceBundle.getBundle("i18n.messages", locale);
		String rawMessage = messageBundle.getString(code.getLanguageKey());
		String ruledMessage = processRawMessage(rawMessage, messageAttributes);
		return ruledMessage;
	}
	
	private String processRawMessage(String rawMessage, Map<String, String> attributes) {
		ST template = new ST(rawMessage);
		if (template!=null) {
			if (attributes!=null) {
				attributes.forEach((key, value) -> {
					template.add(key, value);
				});
			}
		}
		return template.render();
	}
	
	
}
