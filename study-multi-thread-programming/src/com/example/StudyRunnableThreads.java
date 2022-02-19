package com.example;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class StudyRunnableThreads {

	public static void main(String[] args) throws InterruptedException {
		var cpus = Runtime.getRuntime().availableProcessors();
		System.out.println(String.format("There are %d cpus available.",cpus));
		System.err.println(Thread.currentThread().getName()+ " runs main() method.");
		var lotteryTask1 = new LotteryTask();
		var lotteryTask2 = new LotteryTask();
		Thread t1 = new Thread(lotteryTask1); // t1 -> cpu3 -> priority queue
		Thread t2 = new Thread(lotteryTask2); // t2 -> cpu7
		t1.start();
		t2.start();
		t1.join(); // synchronization point!
		System.out.println(lotteryTask1.getLotteryNumbers());
		t2.join(); // synchronization point!
		System.out.println(lotteryTask2.getLotteryNumbers());
		System.out.println("Hello Mars!");
	}

}

class LotteryTask implements Runnable {
	private List<Integer> lotteryNumbers;
	
	public List<Integer> getLotteryNumbers() {
		return lotteryNumbers;
	}

	@Override
	public void run() {
		System.err.println(Thread.currentThread().getName()+ " runs run() method.");
		lotteryNumbers = ThreadLocalRandom.current().ints(0, 60)
		         .distinct()
		         .limit(6)
		         .sorted()
		         .boxed().toList();
	}
	
}