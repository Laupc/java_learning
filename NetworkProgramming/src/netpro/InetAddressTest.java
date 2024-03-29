package netpro;

/**
 * 一、网络编程中两个主要的问题：
 * 1、如何准确定位网络上的一台或多台主机：定位主机上待定的应用
 * 2、找到主机后如何可靠的进行数据传输
 *
 * 二、网络编程中的两个要素：
 * 1、问题1：IP和端口号
 * 2、问题2：网络通信协议： TCP/IP参考模型
 */


import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 通信要素之一：IP和端口号
 * 1、IP：唯一标识Internet上的计算机（通信实体）
 * 2、在Java中使用InetAddress类代表IP
 * 3、IP分类：IPv4 和 IPv6
 *           万维网 和 局域网
 * 4、域名
 * 5、本地环回地址 127.0.0.1 (localhost)
 * 6、实例化InetAddress的两个方法
 *          getByName(String host);
 *          getLocalHost();
 * 7、两个常用方法
 *          getHostName();
 *          getHostAddress();
 * 8、端口号与IP地址的组合得出一个网络套接字：Socket
 */

public class InetAddressTest {
    public static void main(String[] args) {
        try {
            InetAddress inet1 = InetAddress.getByName("220.181.38.150");
            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getByName("www.baidu.com");
            System.out.println(inet2);

            InetAddress localHost = InetAddress.getLocalHost(); //获取本机IP
            System.out.println(localHost);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

    }
}
