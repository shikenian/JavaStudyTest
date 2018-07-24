package com.kshi.simple.nio.bigfile;

import com.sun.deploy.util.StringUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.util.Scanner;

public class ProcessBigFile {
    private final static int length = 0x8000000; // 128 Mb

    public static void main(String[] args) {

        if (test()) return;

        FileChannel channels;
        try {
            channels = new RandomAccessFile(new File(ProcessBigFile.class.getClassLoader().getResource("ProcessBigFile.txt").getFile()), "rw").getChannel();
            MappedByteBuffer mappedByteBuffer = channels.map(FileChannel.MapMode.READ_WRITE, 0, length);
            for (int i = 0; i < length; i++) {
                mappedByteBuffer.put((byte) 'a');
            }
            System.out.println("writing finished");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static boolean test() {
        System.out.println(ProcessBigFile.class.getClassLoader().getResource("ProcessBigFile.txt").getFile());
        FileChannel channels;
        try {
            channels = new RandomAccessFile(new File(ProcessBigFile.class.getClassLoader().getResource("ProcessBigFile.txt").getFile()), "rw").getChannel();
            MappedByteBuffer mappedByteBuffer = channels.map(FileChannel.MapMode.READ_WRITE, 0, length);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

}
