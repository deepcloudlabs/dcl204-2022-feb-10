package com.example;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class LotteryApp {

	public static void main(String[] args) throws InterruptedException {
		var lotteryService = new LotteryService();
		IntStream.range(0, 20).mapToObj(i -> lotteryService.draw(60, 6))
				.forEach(cf -> cf.thenAcceptAsync(lotteryNumbers -> {
					System.err.println(Thread.currentThread().getName() + " is running lambda expression in main...");
					System.err.println(lotteryNumbers);
				}));
		IntStream.range(1, 10).forEach(i -> System.err.println("Working on " + i));
		TimeUnit.SECONDS.sleep(30);
	}

}
