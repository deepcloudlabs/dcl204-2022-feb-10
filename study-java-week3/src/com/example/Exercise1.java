package com.example;

public class Exercise1 {

	public static boolean isOdd(int i) {
		return i%2 != 0;
	}
	
	public static void main(String[] args) {
		System.out.println(isOdd(3)); // true
		System.out.println(isOdd(5)); // true
		System.out.println(isOdd(-3)); // false
		System.out.println(isOdd(-5)); // false
	}

}
