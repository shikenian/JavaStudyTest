package com.kshi.simple.array;

import java.io.File;
import java.util.Arrays;

public class ArrayTest {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// TestFile();
//		List<String> list = Arrays.asList("aaaa", "bbbb", "cccc");
//		for (String str : list) {
//			System.out.println(str);
//		}
		
//		System.out.println(ArrayTest.class.getClassLoader().loadClass("com.kshi.simple.array.ClassToLoad"));
		Class<?> cla = ArrayTest.class.getClassLoader().loadClass("com.kshi.simple.array.ClassToLoad");
		Object obj = cla.newInstance();
		if(obj instanceof ClassToLoad){
			((ClassToLoad) obj).saySomething();
		}
		
	}

	private static void TestFile() {
		File dir = new File("C:\\software\\jisupdf");
		System.out.println(dir.getName());
		System.out.println();
		System.out.println(dir.getPath());
		File[] files = dir.listFiles();
		Arrays.sort(files);
	}
}
