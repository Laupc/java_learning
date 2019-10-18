package io;

import org.junit.Test;

import java.io.*;

/**
 * 其他流的使用
 * 1、标准的输入、输出流
 * 2、打印流
 * 3、数据流
 */
public class OtherStreamTest {
    /**
     * 1.1、标准输入、输出流
     *      System.in 标准输入流，默认从键盘输入
     *      System.out标准的输出流，默认从控制台输出
     * 1.2  System类的setIn(InputStream is)/setOut(PrintStream ps)方式重新制定输入和输出流
     *
     * 1.3  练习
     *      从键盘输入字符串，要求将读取到的整行字符串转成大写输出。
     *      然后继续进行输入操作，直至当输入“e”或者exit时，退出程序。
     */
    public static void main(String[] args) {
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        inputStreamReader = new InputStreamReader(System.in);
        bufferedReader = new BufferedReader(inputStreamReader);

        String result;
        while (true){
            try {
                System.out.println("请输入:");
                result = bufferedReader.readLine();
                if("e".equalsIgnoreCase(result) || "exit".equalsIgnoreCase(result)){
                    break;
                }
                String upperCase = result.toUpperCase();
                System.out.println(upperCase);
            } catch (IOException e) {
                e.printStackTrace();
            }finally {

            }
        }
    }

    //打印流
    @Test
    public void PrintStream(){
        PrintStream printStream = null;
        FileOutputStream fileOutputStream =  null;
        try {
            fileOutputStream  = new FileOutputStream(new File("hello.txt"));
            printStream = new PrintStream(fileOutputStream,true);

            if (printStream != null){
                System.setOut(printStream);
            }
            for(int i = 0; i <= 255;i++){
                System.out.print((char)i);
                if(i % 50 == 0){
                    System.out.println();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            printStream.close();
        }
    }

    /**
     * 3、数据流
     *  3.1 DataInputStream    DataOutputStream
     *  3.2 作用：用于读取或写出基本数据类型的变量和字符串
     */
    @Test
    public void dataIOStreamTest(){
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = null;
        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream("data.txt"));
            dataInputStream = new DataInputStream(new FileInputStream("data.txt"));
            dataOutputStream.writeUTF("Charles");
            dataOutputStream.writeInt(23);
            dataOutputStream.writeBoolean(true);
            dataOutputStream.flush();    //刷新内存，将内存中的数据写入文件

            String name = dataInputStream.readUTF();
            int age = dataInputStream.readInt();
            boolean sex = dataInputStream.readBoolean();
            System.out.println(name + age + sex);



        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
