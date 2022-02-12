package com.example;

public class CompareExercise1 {

	public static void main(String[] args) {
		var counter = 0;
		// change byte to short at least
		for (byte b = -128; b <= 127; ++b) {
			counter++;
		}
		System.out.println("counter: " + counter);
	}

}
