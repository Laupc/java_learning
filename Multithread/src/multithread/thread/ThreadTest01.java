package multithread.thread;


/**
 * 多线程创建
 *      方式一：继承Thread类
 *          1、创建一个继承Thread类的子类
 *          2、重写Thread类的run方法  (将此线程执行的操作声明在run()方法中)
 *          3、创建该子类的对象
 *          4、通过该子类的对象调用start()方法
 *              (1)启动当前线程
 *              (2)调用当前线程的run方法
 * 注：
 *      1、不能通过直接调用run方法启动当前线程
 *      2、同一对象不能多次调用start方法(需要多个对象)
 */

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0;i<1001;i++){
            if (i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}

public class ThreadTest01 {
    public static void main(String[] args) {

        MyThread myThread1 = new MyThread();
        myThread1.start();

    }
}
