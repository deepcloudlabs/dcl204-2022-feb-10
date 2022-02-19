package com.example;

import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings("null")
public class StudyRacingAndThreadSafety {

	public static void main(String[] args) throws InterruptedException {

		var task = new LockFreeCounterTask(); // task.counter -> Java Process::Heap
		var t1 = new Thread(task);
		var t2 = new Thread(task);
		var t3 = new Thread(task);
		t1.start(); t2.start(); t3.start();
		t1.join(); t2.join(); t3.join();
		System.out.println(task.getCounter());
		Object o= null;
		o.wait();
		o.notify();
		o.notifyAll();
		// Synchronizers: 
		//CountDownLatch
		//CyclicBarrier
		// Semaphore -> JDBC Connection Pool
		//ArrayBlockingQueue
		//Phaser
		
	}

}

class CounterTask implements Runnable {
	private volatile int counter; // instance variable -> Heap

	public int getCounter() {
		return counter;
	}

	@Override
	public void run() { // lost update
		for (var i = 0; i < 10_000; ++i)
			synchronized (this) { // mutual exclusion -> Lock -> requires Thread Parking
				                  // CX (Context Switching i) Voluntary CX ii) Non-voluntary CX)
				counter++; // race condition
			}
	}

}

class LockFreeCounterTask implements Runnable {
	// Lock-free Solution
	private AtomicInteger counter= new AtomicInteger(); // instance variable -> Heap
	
	public int getCounter() {
		return counter.get();
	}
	
	@Override
	public void run() { // lost update
		for (var i = 0; i < 10_000; ++i)
			counter.getAndIncrement();
	}
	
}