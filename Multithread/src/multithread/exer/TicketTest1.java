package multithread.exer;

/**
 * 创建三个窗口卖票，总票数为1000张，使用继承Thread
 */

class Window extends Thread{

    private static int ticket = 1000; //保证资源唯一
    @Override
    public void run() {
        while (true){
            synchronized(Window.class){
                if (ticket > 0){
                    System.out.println(getName() + "卖票，票号为：" + ticket);
                    ticket--;
                }else {
                    break;
                }
            }
        }

    }
    public Window(String name){
        super(name);
    }
}

public class TicketTest1 {
    public static void main(String[] args) {
        Window window1 = new Window("窗口1");
        Window window2 = new Window("窗口2");
        Window window3 = new Window("窗口3");

        window1.start();
        window2.start();
        window3.start();
    }
}
