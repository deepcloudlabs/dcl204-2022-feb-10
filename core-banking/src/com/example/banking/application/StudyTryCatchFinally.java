package com.example.banking.application;

public class StudyTryCatchFinally {

	public static void main(String[] args) {
		A a = new A();

		try {
			a.fun();
		} catch (IllegalStateException e) {
			System.err.println(e.getMessage());
		} catch(RuntimeException e){
			System.err.println(e.getMessage());			
		} finally {
			System.err.println("Hello, I am here!");
		}

	}

}

class A {
	void fun() {
		// throw new IllegalStateException("Oopps.");
	}
}