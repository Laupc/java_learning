package file;

import org.junit.Test;

import java.io.File;
import java.util.Date;


public class FileAPITest {
    /**
     * 常用API
     * 涉及读写需要IO流来实现
     * public String getAbsoluPath();       获取绝对路径
     * public String getPath();             获取路径
     * public String getName();             获取名称
     * public String getParent();           获取上层文件目录路径， 无则返回null
     * public Long length();                获取文件长度（字节数），不能获取目录的长度
     * public Long lastModified();          获取最后一次修改时间，毫秒
     * 下面两个方法适用于文件目录
     * public String[] list();              获取指定目录下所有文件或文件目录的名称数组
     * public File[] listFiles              获取指定目录下所有文件或文件目录的File数组
     */
    @Test
    public void test1(){
        File file1 = new File("hello.txt");
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));
        System.out.println("--------------------------------------------");
        File file2 = new File("C:\\Users\\dell\\workspace");
        String[] list = file2.list();
        for(String s:list){
            System.out.println(s);
        }
        System.out.println(" ");
        System.out.println("----------");
        File[] files = file2.listFiles();
        for (File f:files){
            System.out.println(f);
        }
    }


    /**
     * public boolean renameTo(File dest); 把文件重命名为dest
     */
    @Test
    public void test2(){
        File file1 = new File("hello.txt");
        File file2 = new File("hi.txt");
        System.out.println(file1.renameTo(file2));   //file1必须在硬盘中存在
    }


    /**
     * public boolean isDirectory() 判断是否存在该文件目录
     * public boolean isFile()      判断是否是文件
     * public boolean exists()      判断是否存在
     * public boolean canRead()     判断是否可读
     * public boolean canWrite()    判断是否可写
     * public boolean isHidden()    判断是否隐藏
     */
    @Test
    public void test3(){
        File file1 = new File("hello.txt");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());
    }

    /**
     * public boolean createNewFile()     创建文件，若文件存在，则不创建，返回false
     * public boolean mkdir()             创建文件目录，若存在则不创建。若上层不存在，也不创建。
     * public boolean mkdirs()            创建文件目录，若上层不存在，一并创建
     *
     * public boolean delete()            删除文件或文件夹
     */

}
