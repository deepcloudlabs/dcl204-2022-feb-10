package com.example;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class LotteryService {
	private static ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(20);
	// asynchronous method
	public CompletableFuture<List<Integer>> draw(int max, int size){
		return CompletableFuture.supplyAsync(() -> { // Promise
			System.err.println(Thread.currentThread().getName() + " is running lambda expression in draw...");
			var lotteryNumbers = 
					ThreadLocalRandom.current()
					.ints(1, max)
					.distinct()
					.limit(size)
					.sorted()
					.boxed()
					.toList();
			try { TimeUnit.MILLISECONDS.sleep(5); } catch (Exception e) { }
			return lotteryNumbers;			
		}, newFixedThreadPool);
	}
}
