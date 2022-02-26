package com.example;

public class Exercise2 {

	public static void main(String[] args) {
		int x = 3, y = 5;
		System.err.println("x=" + x + ", y=" + y);
        y = ( x ^= ( y ^= x)) ^ y;
        System.err.println("x=" + x + ", y=" + y);
        // operands are integral types (byte, short, int, long)
        // | : bitwise or
        // & : bitwise and
        // ^ : bitwise xor
        
        // 1001 0011
        // 1100 1010
        // ---------
        // 1000 0010 (bitwise and)
        // 1101 1011 (bitwise or)
        // 0101 1001 (bitwise xor) -> networking
        
        // xor : T ^ T = F, F ^ F = F
        //       T ^ F = T, F ^ T = T  

        // operands are boolean
        // || : logical or
        // && : logical and
        y = x ^ y;
        x = x ^ y;
        y = x ^ y;
        var temp = x;
        x = y;
        y = temp;
        
        if ( x==3 || y==5) {
        	
        }
        
        if ( x==3 && y==5) {
        	
        }
        
	}

}
