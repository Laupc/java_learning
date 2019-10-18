package netpro;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 客户端发送文件给服务端，服务端将文件保存
 */
public class TCPTest2 {

    @Test
    public void client(){
        Socket socket = null;
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;
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
