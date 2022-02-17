package com.example.banking.domain;

public enum AccountStatus {
	ACTIVE(100,1), CLOSED(200,2), BLOCKED(300,3);
	private int code;
	private int code2;

	private AccountStatus(int code, int code2) {
		this.code = code;
		this.code2 = code2;
	}

	public int getCode2() {
		return code2;
	}



	public int getCode() {
		return code;
	}
	
}
