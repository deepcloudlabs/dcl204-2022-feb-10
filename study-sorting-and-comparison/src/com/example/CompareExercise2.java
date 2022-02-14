package com.example;

public class CompareExercise2 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// Base: 2, 8, 10, 16
		int x1 = 547; // base 10
		int x2 = 0547; // base 8
		int x3 = 0x547; // base 16, aA:10, bB:11, ..., fF:15
		// since java se 7
		int x4 = 0b0011_1100; // base 2
		System.out.println("x1: "+x1);
		System.out.println("x2: "+x2);
		System.out.println("x3: "+x3);
		System.out.println("x4: "+x4);
		System.out.println(Integer.toHexString(x4));
		System.out.println(Integer.toOctalString(x4));
		System.out.println(Integer.toBinaryString(x4));
		// 1001 0000 : -112
		// 1's complement: 0110 1111
		// add 1           0000 0001
		//                 0111 0000
		byte u=3, v=5, w=0;
		w += u + v; // implicit type casting
		for (byte b = -128; b < 127; ++b) {
			if (b == (byte)0x90) // 1001 0000: 144
				System.out.println("This is b : "+b);
		}
	}

}
