package com.example;

import java.util.List;
import java.util.stream.IntStream;

public class StudyInterfaceJava8 {

	public static void main(String[] args) {
		var numbers = List.of(4,8,15,16,23,42);
		numbers.stream()
		       .filter( J::isEven )
		       .mapToInt( number -> number * number * number)
		       .sum();

	}

}

interface I { // before java 8
	public abstract void fun(); 
	public abstract void gun(); 
	public abstract void sun(); 
}

interface J { // after java 8+
	public abstract void fun(); 
	public abstract void gun(); 
	public abstract void sun(); 
	// 1. default method
	default public void run() {
		
	}; 
	// 2. static method
	// Functional Programming Utility Method
	public static boolean isEven(int number) { 
		return number%2 == 0; 
	}
}

interface K {
	default void fun() {
		haveFun();
	}
	default void sun() {
		haveFun();
	}
	private void haveFun() {} // since java 9 
	public static void haveRun() {
		haveGun();
	}
	public static void haveRun(int x) {
		haveGun();
	}
	private static void haveGun() {} // since java 9
}

class J1 implements J {

	@Override
	public void fun() { }

	@Override
	public void gun() { }

	@Override
	public void sun() {	}
	
}

interface LotteryService {
	List<Integer> draw(int max,int size);
	
	default List<List<Integer>> draw(int max,int size,int column){
		return IntStream.range(0, column)
				        .mapToObj(i -> draw(max,size))
				        .toList();
	}
}













