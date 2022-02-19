package com.example;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadLocalRandom;

public class StudyCallableThreads {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		CallableLotteryTask callableTask = new CallableLotteryTask();
		var futureTask1 = new FutureTask<>(callableTask);
		var futureTask2 = new FutureTask<>(callableTask);
		var futureTask3 = new FutureTask<>(callableTask);
		Thread t1 = new Thread(futureTask1); // t1 -> cpu3 -> priority queue
		Thread t2 = new Thread(futureTask2); // t2 -> cpu7
		Thread t3 = new Thread(futureTask3); // t2 -> cpu7
		t1.start();
		t2.start();
		t3.start();
		System.out.println(futureTask1.get()); // Synchronization + Result
		System.out.println(futureTask2.get());
		System.out.println(futureTask3.get());
		System.out.println("Hello Mars!");
	}

}

// Stateless!
class CallableLotteryTask implements Callable<List<Integer>> {
	@Override
	public List<Integer> call() {
		System.err.println(Thread.currentThread().getName()+ " runs run() method.");
		return ThreadLocalRandom.current().ints(0, 60)
		         .distinct()
		         .limit(6)
		         .sorted()
		         .boxed().toList();
	}
	
}