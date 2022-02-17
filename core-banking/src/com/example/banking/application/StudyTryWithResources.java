package com.example.banking.application;

import java.io.IOException;

public class StudyTryWithResources {

	public static void main(String[] args) throws IOException {
		try(
				var res1 = new PreciousResource(1);
				var res2 = new PreciousResource(2);
				var res3 = new PreciousResource(3);
				var res4 = new PreciousResource(4);
				) {
			System.err.println("Hello Mars!");
		} 	
	}

}

