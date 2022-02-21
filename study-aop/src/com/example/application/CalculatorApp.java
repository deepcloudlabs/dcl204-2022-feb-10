package com.example.application;

import java.lang.reflect.Proxy;
import java.util.stream.IntStream;

import com.example.aspect.CachingAspect;
import com.example.aspect.ProfilingAspect;
import com.example.service.Calculator;
import com.example.service.LotteryService;
import com.example.service.business.StandardCalculator;
import com.example.service.business.StandardLotteryService;

public class CalculatorApp {

	public static void main(String[] args) {
		// Cross-cutting Concerns: i) caching ii) profiling
		StandardCalculator calculator = new StandardCalculator();
		Class<?> clazz = calculator.getClass();
		Calculator calculator2 = (Calculator) Proxy.newProxyInstance(
				clazz.getClassLoader(), 
				clazz.getInterfaces(), 
				new CachingAspect(calculator)
		);
		Calculator calculator3 = (Calculator) Proxy.newProxyInstance(
				clazz.getClassLoader(), 
				clazz.getInterfaces(), 
				new ProfilingAspect(calculator2)
				);		
		calculator.setProxy(calculator3);
		System.out.println(calculator3.getClass());
//		System.out.println(calculator.add(3, 5));
//		System.out.println(calculator.add(3, 5));
//		System.out.println(calculator.add(3, 5));
//		System.out.println(calculator.add(3, 8));
//		System.out.println(calculator.add(3, 8));
//		System.out.println(calculator.add(3, 8));
//		System.out.println(calculator.add(12, 5));
//		System.out.println(calculator.add(12, 5));
//		System.out.println(calculator.sub(3, 5));
		System.out.println(calculator3.mul(100, 50));
//		System.out.println(calculator.div(3, 5));
		LotteryService lotterService = new StandardLotteryService();
		Class<?> clazz2 = lotterService.getClass();
		LotteryService lotterService2 = (LotteryService) Proxy.newProxyInstance(
				clazz2.getClassLoader(), 
				clazz2.getInterfaces(), 
				new ProfilingAspect(lotterService)
				);		
		IntStream.range(0, 10)
		         .mapToObj( i -> lotterService2.draw(60, 6))
		         .forEach(System.out::println);
	}

}
