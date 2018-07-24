package com.kshi.simple.singletontest;

public class ThreadSafeSingleton {
	//使用volatile关键字，可以保证当ThreadSafeSingleton对象在第一个线程中创建完毕的时候，第二个线程可以立马感知到
	private static volatile ThreadSafeSingleton threadSafeSingleton;
	
	private ThreadSafeSingleton(){
		
	}
	
	public ThreadSafeSingleton getInstance(){
		if(threadSafeSingleton == null){
			synchronized (ThreadSafeSingleton.class) {
				//注意，这个非空判断是容易忽略的地方
				//这个判断的作用是针对以下的场景
				//1:线程1获取到锁，并且正在创建对象
				//2:线程2通过了第一个非空判断，正在等待锁资源。这个时候线程1完成了对象创建，准备释放锁
				//3:线程2获得到了锁，然后进行第二个非空判断，发现这个对象已经创建好了，那么则不需要再次创建对象。如果没有这个非空判断，那么有可能线程2会再次创建一个对象
				if(threadSafeSingleton == null){
					threadSafeSingleton = new ThreadSafeSingleton();
				}
			}
		}
		return threadSafeSingleton;
	}
}
