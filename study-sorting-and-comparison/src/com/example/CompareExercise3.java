package com.example;

public class CompareExercise3 {

	public static void main(String[] args) {
		double money = 4.35;
		money = 100.0 * money; // FPU
		System.out.println(String.format("%3.16f", money));
		if (money == 435.0) {
			System.out.println("I have "+money+" \20ba.");
		}
		System.out.println("App is closed!");
	}

}
