package multithread.thread;


/**
 * 创建两个分线程，一个遍历100以内的偶数，一个遍历100以内的基数
 */

public class ThreadTest02 {
    public static void main(String[] args) {
        MyThread01 myThread01 = new MyThread01();
        MyThread02 myThread02 = new MyThread02();
        myThread01.start();
        myThread02.start();
    }
}

class MyThread01 extends Thread{
    @Override
    public void run() {
        for (int i = 0;i<101;i++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + "偶数"+ i);
            }
        }
    }
}

class MyThread02 extends Thread{
    @Override
    public void run() {
        for (int i = 0;i<101;i++){
            if (i % 2 == 0){

            }else {
                System.out.println(Thread.currentThread().getName() + "奇数" + i);
            }
        }
    }
}