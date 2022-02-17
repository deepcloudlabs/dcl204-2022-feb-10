package com.example.lottery.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.ServiceLoader;

import com.example.lottery.service.business.StandardLotteryService;
import com.example.random.service.QualityLevel;
import com.example.random.service.RandomNumberGenerator;
import com.example.random.service.ServiceQuality;

public class LotteryApp {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		var sls = new StandardLotteryService();
		var services = 
		ServiceLoader.load(RandomNumberGenerator.class);
		var props = new Properties();
		File file = new File("src","application.properties");
		props.load(new FileInputStream(file));
		var qualityLevel = QualityLevel.valueOf(
		   props.get("random.number.service").toString()
		);
		services.stream()
		        .filter(service -> 
		        service.get()
		               .getClass()
		               .isAnnotationPresent(
		            		   ServiceQuality.class))
		         .filter(service -> 
		            service.get()
			               .getClass()
			               .getAnnotation(ServiceQuality.class)
			               .value() == qualityLevel )
		        .findFirst()
		        .ifPresent(service ->
					sls.setRandomNumberGenerator(
						service.get()
					)
		        );
	
		sls.draw(60, 6, 10)
		   .forEach(System.out::println);
	}

}
