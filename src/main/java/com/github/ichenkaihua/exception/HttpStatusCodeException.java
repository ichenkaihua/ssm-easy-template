package com.github.ichenkaihua.exception;

public class HttpStatusCodeException extends RuntimeException {

	public HttpStatusCodeException(int statusCode) {
		super();
		this.statusCode = statusCode;

	}

	public HttpStatusCodeException(int statusCode, String reson) {
		super();
		this.statusCode = statusCode;
		this.reson = reson;
	}

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getReson() {
		return reson;
	}

	public void setReson(String reson) {
		this.reson = reson;
	}

	private int statusCode;
	private String reson;

}
