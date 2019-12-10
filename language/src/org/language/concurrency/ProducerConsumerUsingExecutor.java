package org.language.concurrency;

import java.util.LinkedList;
import java.util.List;

public class ProducerConsumerUsingExecutor {

	ExecutorServiceThreadPool executorServiceThreadPool;
	static List<Integer> queuedData = new LinkedList<Integer>();

	public static void main(String[] args) {
		ProducerConsumerUsingExecutor prodConsumer = new ProducerConsumerUsingExecutor();
		prodConsumer.init();
		queuedData.forEach(x -> {
			System.out.println("Element: " + x);
		});
	}

	private void init() {
		executorServiceThreadPool = new ExecutorServiceThreadPool();
		int i = 0;
		while (i < 10) {
			executorServiceThreadPool.submitRunnable(new Producer(i));
			executorServiceThreadPool.submitRunnable(new Consumer());
			i++;
		}
		executorServiceThreadPool.shutdownExecutor();
	}

	private class Producer implements Runnable {
		int producerData;

		public Producer(int data) {
			this.producerData = data;
		}

		@Override
		public void run() {
			try {
				executorServiceThreadPool.queue.put(producerData);
				System.out.println("Data Produced: " + producerData);
				Thread.sleep(3000);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
	}

	private class Consumer implements Runnable {
		@Override
		public void run() {
			try {
				Integer remove = executorServiceThreadPool.queue.remove();
				System.out.println("Data consumed: " + remove);
				queuedData.add(remove);
				Thread.sleep(3000);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
}
