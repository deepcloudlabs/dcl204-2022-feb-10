package com.example;

public class StudyFinal {

	public static void main(String[] args) {
		// 1. class + method -> extensibility
		// 2. Field + Local Var. + Parameter -> constant
	}

}
class B {
	final void fun() {}
}

class C extends B {

	// Error
//	@Override
//	void fun(int) {
//
//	}
	
}
//class A extends String {}
//class B extends Integer{}
final class A {
	final int x = 42;

	public int getX() {
		return x;
	}
	
}

