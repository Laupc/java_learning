package multithread.exer;

/**
 * 创建三个窗口卖票，总票数为1000张，使用继承Thread
 *
 *    使用同步方法解决线程安全问题
 */

class Window04 extends Thread{

    private static int ticket = 1000; //保证资源唯一
    @Override
    public void run() {
        while (true){
            sellTicket();
        }

    }
    //同步监视器：Window04.class
    private static synchronized void sellTicket(){
        if (ticket > 0){
            System.out.println(Thread.currentThread().getName() + "卖票，票号为：" + ticket);
            ticket--;
        }
    }

    public Window04(String name){
        super(name);
    }
}

public class TicketTest4 {
    public static void main(String[] args) {
        Window window1 = new Window("窗口1");
        Window window2 = new Window("窗口2");
        Window window3 = new Window("窗口3");

        window1.start();
        window2.start();
        window3.start();
    }
}
