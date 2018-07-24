package com.kshi.simple.nio.niotest;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

public class SimpleTest {
	public static void main(String[] args) throws IOException {
		
		//FileChannel 是没法作为一个非阻塞的流的，所以没法使用selector
		System.out.println("Simple test for NIO");
		ByteBuffer buffer = ByteBuffer.allocate(1024);//申请1M的缓存空间
		Selector selector = Selector.open();
		File file = new File("C:\\Users\\kshi\\Desktop\\test.txt");
		RandomAccessFile accessfile = new RandomAccessFile(file, "rw");
		FileChannel channel = accessfile.getChannel();
		
		int byteRead = -1;
		//ArrayList<byte[]> arrlist = new ArrayList();
		while ((byteRead = channel.read(buffer)) != -1){
			byteRead = channel.read(buffer);
			
			byte[] data = buffer.array();
			//List<byte[]> list = Arrays.asList(data);
			//arrlist.addAll(list);
			System.out.println(new String(data, "UTF-8"));
			buffer.flip();
		}
		
		//String aaa = new String
		
		
		
		
		
	}
}
