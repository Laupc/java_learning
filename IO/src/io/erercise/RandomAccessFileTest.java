package io.erercise;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * 1、直接继承与Object，实现了DataInput和DataOutput接口
 * 2、既可以作为输入流，也可以作为输出流
 *
 * 3、作为输出流时，如果写出到的文件不存在，则执行过程中自动创建
 *                如果写出到的文件存在，则默认会对原有文件内容从头开始 覆盖
 *
 * API：
 *    作为输出流  void  seek(long position)  将指针指定到position（默认从0开始 ）
 */
public class RandomAccessFileTest {
    @Test
    public void test(){
        try {
            RandomAccessFile randomAccessFile1 = new RandomAccessFile(new File("520.jpg"),"r");
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(new File("520.jpg"),"rw");

            byte[] buffer = new byte[1024];
            int len;
            while ((len= randomAccessFile2.read()) != -1){
                randomAccessFile2.write(buffer,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 通过seek实现插入功能
     */
    @Test
    public void Insert(){
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile("hello.txt","rw");
            randomAccessFile.seek(3);

            StringBuilder builder = new StringBuilder((int)(new File("hello.txt").length()));
            byte[] buffer = new byte[32];
            int len;
            while ((len = randomAccessFile.read(buffer)) != -1){
                builder.append(new String(buffer,0,len));
            }
            randomAccessFile.seek(3);
            randomAccessFile.write("123".getBytes());
            randomAccessFile.write(builder.toString().getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
