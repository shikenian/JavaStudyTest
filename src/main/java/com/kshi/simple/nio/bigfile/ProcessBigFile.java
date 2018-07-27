package com.kshi.simple.nio.bigfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ProcessBigFile {
    private final static int length = 0x8000000; // 128 Mb

    public static void main(String[] args) {
        String filepath = getFilepathFromClasspath("ProcessBigFile.txt");
        processBigFileByLine(filepath, "utf-8");


    }

    private static String getFilepathFromClasspath(String filename) {
        if (null == filename || filename.trim().equals("")) {
            throw new IllegalArgumentException("File name can't be " + filename == null ? "null" : "empty");
        }
        return ProcessBigFile.class.getClassLoader().getResource(filename).getFile();

    }

    private static void processBigFileByLine(String filepath, String charset) {
        int bufSize = 1024 * 1024 * 5;
        FileChannel fileChannel;
        ByteBuffer byteBuffer = ByteBuffer.allocate(bufSize);
//        ByteBuffer.allocateDirect()

        try {
            File file = new File(filepath);
            if (!file.exists()) {
                throw new IllegalArgumentException("file is not exist");
            }
            fileChannel = new RandomAccessFile(file, "rw").getChannel();

            while (fileChannel.read(byteBuffer) != -1) {
                int size = byteBuffer.position();
                byteBuffer.rewind();
                byteBuffer.array();

                //https://www.cnblogs.com/jpfss/p/8991385.html
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}
