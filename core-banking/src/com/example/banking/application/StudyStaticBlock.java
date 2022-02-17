package com.example.banking.application;

public class StudyStaticBlock {

	public static void main(String[] args) {
		new H();
		new H(42);
		new H();
		new H(108);

	}

}

class H {
//	private static int value = 42;
	
	public H(){
		System.err.println("Hello Jupyter!");		
	}
	public H(int x){
		System.err.println("Hello Moon!");		
	}
	
	static { // static initializer block
		System.err.println("Hello Mars!");
	}
	
}
