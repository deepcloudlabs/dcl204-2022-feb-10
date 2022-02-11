package com.example;

public class StudyChar {

	public static void main(String[] args) {
		char c = 'x'; // 2-byte, unsigned int, unicode
		System.out.println("c: "+(char)(c+1));
        c = '\u20ba';
        System.out.println(c);
	}

}
