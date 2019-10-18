package io;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流
 *
 * 1、缓冲流
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 *
 * 2、作用：提高流的读取、写入速度
 *
 * flush  刷新缓冲区，将缓冲区内容写入硬盘
 *
 * 3、处理流，“套接”在已有的流之上
 */
public class IO_BufferedTest {

    //实现非文本文件的复制
    @Test
    public void BufferedStreamTest(){
        File srcFile = new File("520.jpg");
        File destFile = new File("522.jpg");

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(destFile);

            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            byte[] bytes = new byte[8];
            int len;
            while ((len = bufferedInputStream.read(bytes)) != -1){
                bufferedOutputStream.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭资源，从外往里关    (默认关闭外层后，内层自动关闭)
            try {
                bufferedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bufferedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //复制文本文件
    @Test
    public void BufferedReaderAndWriter(){
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(new File("hello.txt")));
            bufferedWriter = new BufferedWriter(new FileWriter(new File("hi.txt")));

            char[] chars = new char[8];
            int len;
            while ((len = bufferedReader.read(chars)) != -1){
                bufferedWriter.write(chars,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (bufferedReader != null){
                    bufferedReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bufferedWriter != null){
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
