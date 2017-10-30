package com.imaginamos.example.util.response;

import java.io.Serializable;

public class Response implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7008528231983785562L;
	
	private String code;
	private String message;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
