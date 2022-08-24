package com.dailycodebuffer.userservice.Exception;

public class NoSuchCustmomerExistsException extends RuntimeException{

	private String msg;

	public NoSuchCustmomerExistsException() {
		
	}
	
	public NoSuchCustmomerExistsException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
