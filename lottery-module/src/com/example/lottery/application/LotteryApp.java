package com.example.lottery.application;

import java.util.ServiceLoader;

import com.example.lottery.service.business.StandardLotteryService;
import com.example.random.service.RandomNumberGenerator;

public class LotteryApp {

	public static void main(String[] args) {
		var sls = new StandardLotteryService();
		var services = 
		ServiceLoader.load(RandomNumberGenerator.class);
				                 
		sls.setRandomNumberGenerator(
				services.findFirst().get()
		);
	
		sls.draw(60, 6, 10)
		   .forEach(System.out::println);
	}

}
