package multithread.thread;


/**
 * Thread中常用方法
 *     1、start()
 *          启动当前线程，调用当前线程的run方法
 *     2、run()
 *          继承Thread的子类重写该方法，并在run方法中声明要执行的操作
 *     3、currentThread()
 *          静态方法，返回执行当前代码的线程
 *     4、getName()
 *          获取当前线程的名字
 *     5、setName()
 *          设置当前线程的名字
 *     6、yield()
 *          调用此方法会释放当前CPU的执行权(有可能还会将执行权 分配给该线程)
 *     7、join()
 *          在线程A中调用线程B的join方法，此时线程A会进入阻塞状态，待线程B完全执行完后，停止A线程的阻塞
 *     8、(static) sleep(long millitime)
 *          让当前线程(不是分线程)阻塞 millitime毫秒
 *     9、isAlive()
 *          判断当前线程是否存活
 *  注：
 *      sleep只能try/catch，因为Thread没有抛异常，子类重写的方法抛出的异常不能比父类大
 *
 *
 *
 *  线程优先级
 *      1、
 *          (1)、MAX_PRIORITY: 10
 *          (2)、MIN_PRIORITY: 1
 *          (3)、NORM_PRIORITY：5    默认优先级
 *      2、获取和设置当前线程优先级
 *          getPriority() 获取当前线程的优先级
 *          setPriority() 设置当前线程的优先级
 *   高优先级的线程会抢占低优先级线程CPU的执行权，但只是执行概率问题，并不意味着一定执行完以后才会执行低优先级的线程
 */

class HelloThread extends Thread{

    @Override
    public void run() {
        for (int i = 0;i<1001;i++){
            if (i % 2 == 0){

                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() +": "+ i);
            }
        }
    }

    public HelloThread(String name){
        super(name);    //Thread中   通过  Thread(String name)可以直接设置线程名
    }

}
public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread helloThread = new HelloThread("HelloThread");
        Thread.currentThread().setName("主线程");
        helloThread.start();
        for (int i = 0;i<101;i++){
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName() +": " + i);
            }
        }
    }
}
