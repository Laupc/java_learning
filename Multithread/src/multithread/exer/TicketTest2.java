package multithread.exer;

/**
 * 创建三个窗口卖票，总票数为1000张，使用实现Runnbale接口
 *
 * 1、问题：卖票过程中，出现了重票、错票(线程安全问题)
 * 2、题出现原因：当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来，也操作车票。
 * 3、解决办法：当一个线程A在操作ticket的时候，其他线程不能参与进来。知道线程A操作完ticket，其他线程才可以开始操作。
 *              这种情况即使线程A出现了阻塞，也不能改变。
 * 4、Java中通过同步机制，解决线程安全问题
 *
 *      方式一：同步代码块
 *             synchronized(同步监视器){
 *                   //需要被同步的代码
 *             }
 *          注：
 *            需要被同步的代码：
 *               操作共享数据的代码。(不能包多，不能包少)
 *            同步监视器：
 *               俗称：锁。任何一个类的对象，都可以充当锁。*但多个线程必须共用同一把锁。
 *           1、在实现Runnable接口时候，可以考虑用this充当同步监视器。
 *           2、在继承Thread类时，可以  考虑用Thread的 子类.class充当同步监视器。
 *
 *      方式二：同步方法
 *              如果操作共享数据的代码完整的声明在一个方法中，我们不妨将此方法声明为同步的。
 *           注：
 *              同步方法仍需要同步监视器，只是不需要显示声明
 *              1、非静态的同步方法，同步监视器是this
 *              2、静态的同步方法，同步监视器是当前类本身
 *
 * 5、局限性：同步的方式解决了线程安全问题，但操作同步代码时，只能有一个线程参与，其他线程等待。
 *    相当于一个单线程的过程，效率低。
 */

class Window01 implements Runnable{
    private int ticket = 1000;
    Object lock = new Object();
    @Override
    public void run() {
        while (true){
            //synchronized(lock){
            //实现Runnable接口，同一个实现类的对象(window)传给多个Thread接口，多个Thread对象公用同一把锁window
            synchronized(this){
                if (ticket>0){
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ": 卖票，票号为：" + ticket);
                    ticket--;
                }else{
                    break;
                }
            }
        }
    }
}
public class TicketTest2 {

    public static void main(String[] args) {

        Window01 window = new Window01();;

        Thread window01 = new Thread(window);
        Thread window02 = new Thread(window);
        Thread window03 = new Thread(window);

        window01.setName("窗口一");
        window02.setName("窗口二");
        window03.setName("窗口三");

        window01.start();
        window02.start();
        window03.start();
    }
}
