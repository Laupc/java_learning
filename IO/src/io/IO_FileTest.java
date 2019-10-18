package io;

import org.junit.Test;

import java.io.*;

public class IO_FileTest {
    /*
            抽象基类            节点流（或文件流）
            InputStream         FileInputStream
            OutputStream        FileOutputStream
            Reader              FileReader
            Writer              FileWriter

            对于文本文件(.txt , .java .c等)，使用字符流处理
            对于非文本文件(图片，视频，音频,doc,ppt等)，使用字节流处理
     */
    @Test
    public void fileReaderTest1(){
        FileReader fileReader = null;
        try {
            //1、实例化File类对象
            File file = new File("hello.txt");
            //2、创建流
            fileReader = new FileReader(file);
            //3、数据读入
            //read()返回读入的一个字符，若结束返回-1;
            int result = fileReader.read();
            while (result != -1){
                System.out.print((char)result);
                result = fileReader.read();
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            //4、关闭流
            /**
             * 为了保证资源一定可以执行关闭操作，需要使用try-catch-finally处理
             */
            try {
                if(fileReader != null){
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //read()重载方法
    @Test
    public void fileReaderTest2(){
        FileReader fileReader = null;
        try {
            File file = new File("hello.txt");
            fileReader = new FileReader(file);

            /**
             * read(char[] cbuf)    返回每次读入cbuf数组中字符的个数，达到末尾返回-1
             *
             */
            char[] cbuf = new char[5];
            int result = fileReader.read(cbuf);
            while (result != -1){
                /**
                 * 错误写法   每次循环结果都会覆盖cbuf的值，若最后一次查询结果不满5个，则只会覆盖前面的值
                 * for(int i=0;i<cbuf.length;i++){
                 *       System.out.print(cbuf[i]);
                 * }
                 */
                for(int i=0;i<result;i++){
                    System.out.print(cbuf[i]);
                }
                result = fileReader.read(cbuf);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (fileReader != null){
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 将内存数据写入到硬盘文件中
     * new FileWriter(file)   //覆盖原有file
     * new FileWriter(file,boolean append) //append:true 在原有文件后追加写入   false  不在原有文件后追加写入，默认false
     */
    @Test
    public void fileWriterTest(){
        String[] str = {"h","e","l","l","o"};
        char[] chars = {'h','e','l','l','o'};
        File file = new File("hello.txt");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write("I have a dream");

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void FileReaderAndWriter(){
        File writerFile = new File("writer.txt");
        File readerFile = new File("read.txt");

        FileWriter fileWriter = null;
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(readerFile);
            fileWriter = new FileWriter(writerFile);

            char[] cbuf = new char[5];
            int len;
            while ((len = fileReader.read(cbuf)) != -1){
               fileWriter.write(cbuf,0,len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileReader.close();
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    /**
     * FileInputStream and FileOutputStream
     * 使用字节流处理文本文件可能出现乱码
     */
    @Test
    public void FileInputOutputStreamTest(){
        File srcFile = new File("520.jpg");
        File destFile = new File("521.jpg");

        FileOutputStream fileOutputStream = null;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(destFile);

            byte[] buffer = new byte[5];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
