package com.example;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

public class StudyObjectLayout {

	public static void main(String[] args) {
		System.out.println(VM.current().details());	
		System.out.println(ClassLayout.parseClass(A.class).toPrintable());	
	}

}

// 64 Byte = 57 Byte
class A {			    // 12 (Object Header)
	byte b1;  			// 1
	byte b2;  			// 1
	byte b3;  			// 1
	short s1; 			// 2
	short s2; 			// 2
	int i;     			// 4
	char c1='\u20ba';  	// 2
	long l1;			// 8
	char c2='\u20ba';	// 2
	long l2;			// 8	
	boolean x1;			// 1
	float f;			// 4
//	boolean x2;			// 1
	double d;			// 8 
}
