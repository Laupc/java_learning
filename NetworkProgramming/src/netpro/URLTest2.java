package netpro;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLTest2 {
    public static void main(String[] args) {
        HttpURLConnection httpURLConnection = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;

        URL url = null;
        try {
            url = new URL("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1571035226167&di=02a7ac9891534b4ec7df36e82cc37c58&imgtype=0&src=http%3A%2F%2Fb-ssl.duitang.com%2Fuploads%2Fitem%2F201603%2F14%2F20160314162424_LZ8Y5.thumb.700_0.jpeg");

            httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.connect();

            inputStream = httpURLConnection.getInputStream();
            fileOutputStream = new FileOutputStream("NetworkProgramming\\522.jpg");

            byte[] buffer = new byte[1024];
            int len;
            while ((len = inputStream.read(buffer)) != -1){
                fileOutputStream.write(buffer,0,len);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            httpURLConnection.disconnect();
        }


    }
}
