package com.example;

import java.math.BigDecimal;

@SuppressWarnings("unused")
public class StudyFloatingPointTypes {

	public static void main(String[] args) {
		float pi = 3.141516171819F; // 4-byte
		double x = 2.0; // 8-byte // FPU

		x = x - 1.10; // IEEE-754
		System.out.println(String.format("%3.16f", x));

		float f = 1_000_000_000;
		f = f + 50;

		System.out.println(String.format("%12.16f", f));
		// Immutable
		BigDecimal bd = BigDecimal.valueOf(2.0);
		bd = bd.subtract(BigDecimal.valueOf(1.1));
		System.out.println(bd.toString());

		x = 0 / 0.; // FPU
		System.out.println("x: " + x);
		System.out.println("is x NaN: " + Double.isNaN(x));
	}

}
