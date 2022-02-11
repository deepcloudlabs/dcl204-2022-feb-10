package com.example;

public class StudyString {

	public static void main(String[] args) {
		String name2 = new String("jack");
		name2 = name2.intern();
		String name1= "jack";
		String name3= "jack";
		System.out.println("name1==name2: "+(name1==name2));	
		System.out.println("name1==name3: "+(name1==name3));	
	    name1 = name1.toUpperCase();
	    System.out.println(name1);
	    System.out.println("name1==name2: "+(name1==name2));	
	    System.out.println("name1==name3: "+(name1==name3));	
	}

}
