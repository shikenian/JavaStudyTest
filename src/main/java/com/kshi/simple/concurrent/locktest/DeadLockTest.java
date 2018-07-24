package com.kshi.simple.concurrent.locktest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockTest {
//	private Object A = new Object();
//	private Object B = new Object();
	
	
	
	public static void main(String[] args) {
		Lock A = new ReentrantLock();
		Lock B = new ReentrantLock();
		
		
		new Thread(){
			public void run(){
				System.out.println("Thread1 -- trying to get lock A");
				A.lock();
				System.out.println("Thread1 -- get lock A successfully!");
				
				try {
					sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("Thread1 -- trying to get lock B");
				B.lock();
				System.out.println("Thread1 -- get lock B successfully!");
			}
		}.start();
		
		
		new Thread(){
			public void run(){
				System.out.println("Thread2 -- trying to get lock B");
				B.lock();
				System.out.println("Thread2 -- get lock A successfully!");
				
				try {
					sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("Thread2 -- trying to get lock A");
				A.lock();
				System.out.println("Thread2 -- get lock B successfully!");
			}
		}.start();
		
	}
}
