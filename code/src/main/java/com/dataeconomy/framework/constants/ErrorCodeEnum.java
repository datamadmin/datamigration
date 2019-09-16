package com.dataeconomy.framework.constants;

/**
 * 
 * @author GUVALA
 *
 */
public enum ErrorCodeEnum {

	USER_DISABLED_MSG("USER_DISABLED_MSG"),
	USER_LOCKED_MSG("USER_LOCKED_MSG"),
	INVALID_EMAIL_OR_USERNAME("USER_NAME_NOT_EXIST"),
	INVALID_CREDENTIALS("INVALID_CREDENTIALS");
	public String key;
	public Integer statusCode=501;
	
	

	ErrorCodeEnum(String key) {
		this.key = key;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

}
