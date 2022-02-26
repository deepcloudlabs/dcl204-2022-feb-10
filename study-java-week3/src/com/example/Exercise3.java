package com.example;

@SuppressWarnings("unused")
public class Exercise3 {

	public static void main(String[] args) {
		// JLS
		char c = 'X';
		int i = 0;
		System.out.print( true ? c : 0); // X
		System.out.print(false ? i : c); // 88
		System.out.println(0 + c);
	}

}
