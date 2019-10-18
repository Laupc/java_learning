package multithread.exer;

/**
 * 使用同步方法实现Runnable
 */


class Window03 implements Runnable{
    private int ticket = 1000;
    Object lock = new Object();

    //类似同步代码块，此时的同步监视器是 this
    private synchronized void sellTicket(){
        if (ticket>0){
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": 卖票，票号为：" + ticket);
            ticket--;
        }
    }

    @Override
    public void run() {
        while (true){
            sellTicket();
        }
    }
}
public class TicketTest3 {

    public static void main(String[] args) {

        Window03 window = new Window03();;

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