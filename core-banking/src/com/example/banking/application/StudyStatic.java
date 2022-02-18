package com.example.banking.application;

import static com.example.banking.application.F.getValue;

@SuppressWarnings("static-access")
public class StudyStatic {

	public static void main(String[] args) {
		F f = null;
		System.out.println(((F)null).getValue());
		System.out.println(f.getValue());
		System.out.println(getValue());
	}

}

class F {
	private static int value=0;
	public static int getValue() { return value;}
	public int fun() {return 42;}
}