package netpro;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * UDP网络编程
 */
public class UDPTest {

    //发送端
    @Test
    public void sender(){
        DatagramSocket datagramSocket = null;
        DatagramPacket datagramPacket = null;
        try {
            datagramSocket = new DatagramSocket();

            byte[] data = "这是UDP方式发送的数据".getBytes();
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            datagramPacket = new DatagramPacket(data,0,data.length,inetAddress,8088);

            datagramSocket.send(datagramPacket);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            datagramSocket.close();
        }
    }

    //接收端
    @Test
    public void receiver(){
        DatagramSocket datagramSocket = null;
        DatagramPacket datagramPacket = null;
        try {
            datagramSocket = new DatagramSocket(8088);

            byte[] buffer = new byte[128];
            datagramPacket = new DatagramPacket(buffer,0,buffer.length);

            datagramSocket.receive(datagramPacket);

            System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getLength()));
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
