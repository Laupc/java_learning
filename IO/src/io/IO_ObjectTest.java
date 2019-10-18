package io;

import io.erercise.Person;
import org.junit.Test;

import java.io.*;

/**
 * 对象流的使用
 * 1、ObjectInputStream  和   ObjectOutputStream
 * 2、作用：用于存储和读取基本数据类型数据或对象的处理流。
 *          可以将Java中的对象写入数据源，也可以将数据源中的数据还原回来。
 */
public class IO_ObjectTest {
    /**
     * 序列化
     *      将内存中的Java对象保存到磁盘中或通过网络传输出去
     *      使用ObjectOutput实现
     */
    @Test
    public void objectOutputStreamTest(){
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("object.dat"));
            objectOutputStream.writeObject(new Person("卢本伟",23));
            objectOutputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 反序列化
     */
    @Test
    public void objectInputStreamTest(){
        ObjectInputStream objectInputStream = null;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream("object.dat"));
            Object o = objectInputStream.readObject();
            Person p = (Person) o;
            System.out.println(p);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
