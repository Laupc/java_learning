package netpro;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;


/**
 * 客服端发送文件给服务端，服务端保存至本地，并反馈给客户端“发送成功”。
 */
public class TCPTest3 {
    @Test
    public void client(){
        Socket socket = null;
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        InputStream inputStream = null;
        try {

            socket = new Socket(InetAddress.getByName("127.0.0.1"),8088);

            outputStream = socket.getOutputStream();

            File file = new File("520.jpg");
            fileInputStream = new FileInputStream(file);

            byte[] buffer = new byte[1024];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1){
                outputStream.write(buffer,0,len);
            }
            //关闭输出，停止服务端阻塞
            socket.shutdownOutput();
            //获取服务端反馈，若上方没有关闭输出，则服务端会一直接受，不会给予反馈
            inputStream = socket.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int len1;
            byte[] buffer1 = new byte[16];
            while ((len = inputStream.read(buffer1)) != -1){
                byteArrayOutputStream.write(buffer1,0,len);
            }
            System.out.println(byteArrayOutputStream.toString());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void server(){

        ServerSocket serverSocket = null;
        FileOutputStream fileOutputStream = null;
        OutputStream outputStream = null;

        try {
            serverSocket = new ServerSocket(8088);
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            fileOutputStream = new FileOutputStream(new File("521.jpg"));

            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer,0,len);
            }

            outputStream = socket.getOutputStream();
            outputStream.write("我已收到照片，谢谢。".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                serverSocket.close();
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
