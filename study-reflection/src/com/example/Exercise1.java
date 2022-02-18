package com.example;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

@SuppressWarnings("unused")
public class Exercise1 {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, FileNotFoundException, IOException {
		var clazz1 = int.class;
		System.err.println(clazz1.getClass());
		// Before Java 8: Permanent Generation (PermGen)
		// After Java 8: MetaSpace
		
		var clazz2 = int[].class;
		var clazz3 = int[][].class;
		var clazz4 = String.class;
		String name = "jack";
		File file = new File("src","application.properties");
		var props = new Properties();
		props.load(new FileInputStream(file));
		var methodName = props.get("method.name")
				              .toString();
		var caseMethod = 
				clazz4.getDeclaredMethod(methodName);
		System.out.println(caseMethod.invoke(name));

	}

}
