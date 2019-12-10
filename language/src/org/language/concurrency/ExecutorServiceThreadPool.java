package org.language.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceThreadPool {

	ExecutorService executor = Executors.newFixedThreadPool(2);
	BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(2);

	public void submitRunnable(Runnable r) {
		executor.execute(r);
	}

	public void shutdownExecutor() {
		try {
			executor.shutdown();
			executor.awaitTermination(5, TimeUnit.SECONDS);
		} catch (Exception ex) {
			System.out.println("Exception while shuttingdown executor: " + ex);
		}
		System.out.println("Finished all threads.");
	}
}
