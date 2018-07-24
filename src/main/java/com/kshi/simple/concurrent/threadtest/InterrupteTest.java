package com.kshi.simple.concurrent.threadtest;

import java.util.Date;

public class InterrupteTest {

	private static Object lock = new Object();

	public static void main(String[] args) {

		// 测试线程调用sleep方法时被执行Interrupt
		// 线程会被成功结束掉
		Thread t1 = new Thread(() -> {
			try {
				Thread.sleep(10000);
			} catch (Exception e) {
				System.out.println("Thread1 is interrupted " + new Date().toString());
			}
		});

		// 测试当一个线程处于wait状态时，被外部线程调用Interrupt方法
		// 线程如果处于wait状态会被成功地结束掉
		Thread t2 = new Thread(() -> {
			try {
				syncMethod();
			} catch (Exception e) {
				System.out.println("Thread2 is interrupted " + new Date().toString());
			}
		});
		// 测试一个线程调用自己本身的interrupt()方法 -- 在线程阻塞之前调用
		// 可以成功的把当前线程给结束掉
		Thread t3 = new Thread(() -> {
			try {
				Thread.currentThread().interrupt();
				syncMethod();
			} catch (InterruptedException e) {
				System.out.println("Thread3 is interrupted" + new Date().toString());
			}
		});

		// 测试一个线程调用自己本身的interrupt()方法 -- 在线程阻塞之后调用
		// Interrupt方法执行时，当前线程已经退出了阻塞状态，所以对当前线程没有影响

		Thread t4 = new Thread(() -> {
			try {

				syncMethod();
				Thread.currentThread().interrupt();

			} catch (InterruptedException e) {
				System.out.println("Thread4 is interrupted" + new Date().toString());
			}
		});

		System.out.println("begin interrupt Thread1 " + new Date().toString());

		t1.setName("Thread1");
		t1.start();
		t1.interrupt();

		System.out.println("begin interrupt Thread2 " + new Date().toString());
		t2.setName("Thread2");
		t2.start();
		t2.interrupt();

		System.out.println("begin interrupt Thread3 " + new Date().toString());
		t3.setName("Thread3");
		t3.start();

		System.out.println("begin interrupt Thread4 " + new Date().toString());
		t4.setName("Thread4");
		t4.start();

	}

	private static void syncMethod() throws InterruptedException {
		synchronized (lock) {
			System.out.println(Thread.currentThread().getName() + " is calling syncMethod " + new Date().toString());
			lock.wait(10000);
		}
	}
}
