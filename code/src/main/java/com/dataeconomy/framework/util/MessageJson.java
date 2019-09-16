package com.dataeconomy.framework.util;

public class MessageJson {

	private Integer messageCode;

	private String message;

	private String details;

	public MessageJson(Integer messageCode, String message) {
		super();
		this.messageCode = messageCode;
		this.message = message;
	}

	public MessageJson(Integer messageCode, String message, String details) {
		super();
		this.messageCode = messageCode;
		this.message = message;
		this.details = details;
	}

	public Integer getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(Integer messageCode) {
		this.messageCode = messageCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

}
