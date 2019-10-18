package file;

import java.io.File;
/**
 * 3. 遍历指定目录所有文件名称，包括子文件目录中的文件。
	拓展1：并计算指定目录占用空间的大小
	拓展2：删除指定文件目录及其下的所有文件

 * @author shkstart 邮箱：shkstart@126.com
 * @version  创建时间：2019年2月23日  上午1:55:31
 *
 */
public class ListFilesTest {

	public static void main(String[] args) {
		// 递归:文件目录
		/** 打印出指定目录所有文件名称，包括子文件目录中的文件 */

		// 1.创建目录对象
		File dir = new File("C:\\Game");

		// 2.打印目录的子文件
		printSubFile(dir);

		File file1 = new File("C:\\Game");
		deleteDirectory(file1);

	}

	public static void printSubFile(File dir) {
		//获取指定目录下所有文件或文件目录的File数组
		File[] subfiles = dir.listFiles();
		//遍历该数组
		for (File file : subfiles) {
			//判断若该文件为目录，则进行递归，否则打印路径
			if (file.isDirectory()) {
				printSubFile(file);
			} else {
				System.out.println(file.getAbsolutePath());
			}

		}
	}

	// 方式二：循环实现
	// 列出file目录的下级内容，仅列出一级的话
	// 使用File类的String[] list()比较简单
	public void listSubFiles(File file) {
		if (file.isDirectory()) {
			String[] all = file.list();
			for (String s : all) {
				System.out.println(s);
			}
		} else {
			System.out.println(file + "是文件！");
		}
	}

	// 列出file目录的下级，如果它的下级还是目录，接着列出下级的下级，依次类推
	// 建议使用File类的File[] listFiles()
	public void listAllSubFiles(File file) {
		if (file.isFile()) {
			System.out.println(file);
		} else {
			File[] all = file.listFiles();
			// 如果all[i]是文件，直接打印
			// 如果all[i]是目录，接着再获取它的下一级
			for (File f : all) {
				listAllSubFiles(f);// 递归调用：自己调用自己就叫递归
			}
		}
	}

	// 拓展1：求指定目录所在空间的大小
	// 求任意一个目录的总大小
	public long getDirectorySize(File file) {
		// file是文件，那么直接返回file.length()
		// file是目录，把它的下一级的所有大小加起来就是它的总大小
		long size = 0;
		if (file.isFile()) {
			size += file.length();
		} else {
			File[] all = file.listFiles();// 获取file的下一级
			// 累加all[i]的大小
			for (File f : all) {
				size += getDirectorySize(f);// f的大小;
			}
		}
		return size;
	}

	// 拓展2：删除指定的目录
	public static void deleteDirectory(File file) {
		//如果file是文件夹则删除该文件夹下的所有子文件或目录，然后删除自己
		if (file.isDirectory()) {
			File[] all = file.listFiles();
			// 循环删除的是file的下一级
			for (File f : all) {// f代表file的每一个下级
				deleteDirectory(f);
			}
		}
		// 删除自己
		file.delete();
	}

}
