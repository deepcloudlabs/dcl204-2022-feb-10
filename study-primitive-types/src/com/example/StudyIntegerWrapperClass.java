package com.example;

public class StudyIntegerWrapperClass {
	public static void main(String[] args) {
		// -Djava.lang.Integer.IntegerCache.high=4096
		Integer x = Integer.valueOf(108);	// lost
		Integer y = 108;	
		Integer u = 549;	// 
		Integer v = 549;
		System.out.println("x==y? "+(x==y));
		System.out.println("u==v? "+(u==v));
	}
}
