package com.kshi.simple.concurrent.threadtest;

public class ThreadLocalTest {
	//定义一个ThreadLocal变量
	private ThreadLocal<Integer> number1 = new ThreadLocal<Integer>(){
		public Integer initialValue(){
			return 0;
		}
	};
	
	private Integer number2 = 0;
	
	public Integer getNumber1(){
		number1.set(number1.get()+1);
		return number1.get();
	}
	
	public Integer getNumber2(){
		return ++number2;
	}
	
	public static void main(String[] args) {
		
		ThreadLocalTest test = new ThreadLocalTest();
		
		Thread t1 = new Thread(){
			public void run(){
				for(int i = 0; i < 200000; i++){
					System.out.println("Thread1 Number1 is:" + test.getNumber1() );
					System.out.println("Thread1 Number2 is:" + test.getNumber2() );
				}
				
			}
		};
		
		Thread t2 = new Thread(){
			public void run(){
				for(int i = 0; i < 200000; i++){
					System.out.println("Thread2 Number1 is:" + test.getNumber1() );
					System.out.println("Thread2 Number2 is:" + test.getNumber2() );
				}
				
			}
		};
		
		t1.start();
		t2.start();
	}

}
