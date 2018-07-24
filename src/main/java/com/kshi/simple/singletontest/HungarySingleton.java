package com.kshi.simple.singletontest;

public class HungarySingleton {
	//如果实例化的过程比较复杂，比如依赖一些外部的配置文件等，可以使用静态块的方式，方便我们做一些个性化的创建对象
	private static HungarySingleton hungarySingleton = new HungarySingleton();
	
	private HungarySingleton(){
		
	}
	
	public HungarySingleton getInstance(){
		return hungarySingleton;
	}
}
