package com.myapi.spring.onlinetutorial.model;

public class Welcome {
	
	private String message;

	public Welcome(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return String.format(message, "response");
	}

}
