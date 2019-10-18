package file;

import org.junit.Test;

import java.io.File;
import java.util.Date;

/**
 * 1、File类的一个对象，代表一个文件或者一个目录
 * 2、声明在java.io包下
 */
public class FileTest {
    /**
     * 1、创建File实例
     *      new File(fileURL);
     *      new File(parentURL,childURL);
     *      new File(File parentFile,fileURL)
     * 2、路径
     *      相对路径
     *      绝对路径
     * 3、通过IO流实现读写，将File对象传入流的构造器中，并指明“终点”
     */
    @Test
    public void test1(){
        //构造器1
        //相对路径
        File file01 = new File("hello.txt");
        //绝对路径
        File file02 = new File("C:\\Users\\dell\\Desktop\\hello.txt");
        //File.separator根据操作系统动态提供目录分隔符
        File file03 = new File("C:" + File.separator + "Users" + File.separator +"dell" +File.separator + "Desktop");

        //构造器2
        //C:\Users目录下的dell目录
        File file04 = new File("C:\\Users","dell");

        //构造器3
        //file04目录下的
        File file05 = new File(file04,"hello.txt");
    }
}
