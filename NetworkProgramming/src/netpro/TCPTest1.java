package netpro;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * TCP网络编程
 * 例1：客户端发送消息给服务端并显示在控制台上
 */
public class TCPTest1 {
    @Test
    public void client(){
        Socket socket = null;
        OutputStream outputStream = null;
        try {
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            socket = new Socket(inetAddress,8899);

            outputStream = socket.getOutputStream();
            outputStream.write("你好，我是客户端1。".getBytes());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Test
    public void server()  {
        ServerSocket serverSocket = null;
        InputStream inputStream = null;
        Socket socket = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            //1、创建服务器端的ServerSocket,指明自己的端口号
            serverSocket = new ServerSocket(8899);
            //2、调用accept方法，表明接受来自客户端的socket
            socket = serverSocket.accept();
            //3、获取一个输入流   (获取客户端socket发来的数据)
            inputStream = socket.getInputStream();



            //不建议，会出现乱码
//        byte[] buffer = new byte[256];
//        int len;
//        while ((len = inputStream.read(buffer)) != -1){
//            String str = new String(buffer,0,len);
//            System.out.print(str);
//        }

            //4、读取输入流中数据
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[8];
            int len;
            while ((len = inputStream.read(buffer)) != -1){
                byteArrayOutputStream.write(buffer,0,len);
            }
            System.out.println(byteArrayOutputStream.toString()+"我的IP是："+socket.getInetAddress().getHostAddress());


        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //5、关闭资源
            try {
                byteArrayOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        }


}
