package com.kshi.simple.nio.niotest;

import java.util.HashMap;
import java.util.Map;


public class BufferTest {
	public static void main(String[] args) {
		new BufferTest().testByteBuffer();
	}
	
	public void testByteBuffer(){
//		ByteBuffer buffer = ByteBuffer.allocate(100);
//		buffer.put((byte)'H').put((byte)'E').put((byte)'L').put((byte)'L').put((byte)'L').put((byte)'O');
//		System.out.println(buffer.toString());
//		String result = new String(buffer.array());
//		System.out.println(result);
//		buffer.flip();
//		System.out.println(buffer.toString());
//		String result1 = new String(buffer.array());
//		System.out.println(result1);
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("Hello World","Hello World");
	}
}
