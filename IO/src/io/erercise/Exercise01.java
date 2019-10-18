package io.erercise;

import java.io.*;

public class Exercise01 {
    //图片加密
    public void PictureEncrypt(){
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(new File("520.jpg"));
            fileOutputStream = new FileOutputStream(new File("521.jpg"));

            byte[] bytes = new byte[32];
            int len;
            while ((len = fileInputStream.read(bytes)) != -1){
                for (int i = 0;i<len;i++){
                    bytes[i] = (byte)(bytes[i] ^ 5);       // 解密    m ^ n ^ n = m
                }
                fileOutputStream.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
