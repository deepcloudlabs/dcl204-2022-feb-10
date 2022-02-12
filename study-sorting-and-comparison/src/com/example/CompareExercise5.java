package com.example;

public class CompareExercise5 {

	public static void main(String[] args) {
		String name1 = "jack";
		String name2 = "Jack";
		String name3 = new String("jack");
		System.out.println(name1==name2);
		System.out.println(name1==name3);
		System.out.println(name1.equals(name3));
	}

}
