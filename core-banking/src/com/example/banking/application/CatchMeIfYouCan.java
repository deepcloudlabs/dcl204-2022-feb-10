package com.example.banking.application;

public class CatchMeIfYouCan {
	@SuppressWarnings("finally")
	public static int haveFun() {
		try {
			return 42;
		} finally {
			return 108;
		}
	}
	public static void main(String[] args) {
		System.out.println(haveFun());
	}

}
