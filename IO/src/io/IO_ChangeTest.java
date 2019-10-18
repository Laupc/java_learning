package io;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之二：转换流
 * 1、转换流
 *      InputStreamReader     将一个字节输入流转换为字符输入流
 *      OutputStreamReader    将一个字节输出流转换为字符输出流
 * 2、作用：提供字节流与字符流之间的转换
 *
 * 3、解码：
 *      字节、字节数组     --->  字符串、字符数数组
 *    编码：
 *      字符串、字符串数组 --->   字节、字节数组
 *
 * 4、字符集
 *      ASCII: 美国标准信息交换码，用一个字符的7位表示。
 *      ISO8859-1：拉丁码表，欧洲码表，用一个字节的8位表示。
 *      GB2312：中文编码表，最多两个字节编码所有字符。
 *      GBK：中文编码表升级，融合了更多的中文文字字符，最多两个字节编码。
 *      Unicode：国际标准码，融合了目前人类使用的所有字符，为每个字符分配唯一的字符码。所有字节都使用两个字节来表示
 *      UTF-8:变长的编码方式，可用1-4个字节来表示一个字符
 *
 *
 *      UTF-8编码
 *      （二进制）
 *      0xxxxxxx                              1个字节代表一个字符
 *      110xxxxx 10xxxxxx                     2个字节代表一个字符
 *      1110xxxx 10xxxxxx 10xxxxxx            3个字节代表一个字符
 *      11110xxx 10xxxxxx 10xxxxxx 10xxxxxx   4个字节代表一个字符
 *
 *      比如汉字：尚   Unicode编码值：23578    十六进制 5C1A    二进制   0101 1100 0001 1010
 *              一个汉字三个字节，    1110+0101  10+110000  10+011010
 *                               即  11100101 10110000 10011010
 */
public class IO_ChangeTest {
    @Test
    public void test1(){
        FileInputStream fileInputStream = null;
        InputStreamReader inputStreamReader = null;
        try {
            fileInputStream = new FileInputStream("dbcp.txt");
            //参数二指定字符集， 不写默认使用系统默认字符集，
            inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");

            char[] cbuf = new char[16];
            int len;
            while ((len = inputStreamReader.read(cbuf)) != -1){
                String str = new String(cbuf,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2(){
        File inputFile = new File("dbcp.txt");
        File outputFile = new File("dbcp_gbk.txt");

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;

        try {
            fileInputStream = new FileInputStream(inputFile);
            fileOutputStream = new FileOutputStream(outputFile);

            inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");
            outputStreamWriter = new OutputStreamWriter(fileOutputStream,"GBK");

            char[] cbuf = new char[16];
            int len;
            while ((len = inputStreamReader.read(cbuf)) != -1){
                outputStreamWriter.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStreamReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outputStreamWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
