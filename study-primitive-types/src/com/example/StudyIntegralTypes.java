package com.example;

import java.math.BigInteger;

public class StudyIntegralTypes {

	public static void main(String[] args) {
		// signed
		// 0111 1111
		// 0000 0001
		// 1000 0000 : -128
		// 0111 1111 
		// 0000 0001
		// 1000 0000 : 128
		
		// 1111 1111 : -1
		// 0000 0000
		// 0000 0001
		// 0000 0001
		byte b = 42; // 1-Byte, [-128..127]
		b=127;
		b++;
		System.out.println("b: "+b);
		
		short s = 42; // 2-byte, [-32768..32767]
		s = Short.MAX_VALUE;
		System.out.println("s: "+s);
		s++;
		System.out.println("s: "+s);
		
		int x = 42; // 4-byte, [-2147483648..2147483647]
		x = Integer.MAX_VALUE;
		System.out.println("x: "+x);
		x++;
		System.out.println("x: "+x);

		long y = 42; // 8-byte, [-9223372036854775808..9223372036854775807]
		y = Long.MAX_VALUE;
		System.out.println("y: "+y);
		y++;
		System.out.println("y: "+y);
		// Immutable
		BigInteger bi = BigInteger.valueOf(9223372036854775807L);
	    System.out.println(bi.toString());
		bi = bi.add(BigInteger.ONE);
		System.out.println(bi.toString());
	    
		byte u=127, v = 1, w=0;
		w = (byte)(u + v);
		System.out.println("w: "+w);
		w += w + u + v;
		w = (byte)(w + 1); // w += 1 , w++
		
//		int one = 1/0; // ALU
//		System.out.println("one: "+one);
		
		long z = Integer.MAX_VALUE + 1L;
		System.out.println("z: "+z);
	}

}
