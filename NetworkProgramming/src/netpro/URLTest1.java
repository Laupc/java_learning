package netpro;


import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL 网络编程
 * 1、URL:统一资源定位符，对应着互联网的某一资源地址
 * 2、格式：
 *       http://localhost:8080/user/users?username=Tom
 *       协议    主机名:端口号   资源地址     参数列表
 */
public class URLTest1 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1571035226167&di=02a7ac9891534b4ec7df36e82cc37c58&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201603%2F14%2F20160314162424_LZ8Y5.thumb.700_0.jpeg");

            //获取该URL协议名
            System.out.println(url.getProtocol());
            //获取该URL主机名
            System.out.println(url.getHost());
            //获取该URL的端口号
            System.out.println(url.getPort());
            //获取该URL文件路径
            System.out.println(url.getPath());
            //获取该URL的文件名
            System.out.println(url.getFile());
            //获取该URL的查询名（参数列表）
            System.out.println(url.getQuery());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } finally {

        }
    }
}
