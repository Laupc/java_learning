package multithread.exer;

/**
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 */

class Bank{
    private Bank(){

    }

    private static Bank instance = null;

    public static Bank getInstance(){
        /**
         * 方式一
         *      效率较低
         *      synchronized (Bank.class){
         *             if (instance == null){
         *                 instance = new Bank();
         *                 return instance;
         *             }
         *             return instance;
         *         }
         */
        //方式二：效率较高，可以保证第一个线程以后的线程直接返回
        if (instance == null){
            synchronized (Bank.class){
                if (instance == null){
                    instance = new Bank();
                    return instance;
                }
            }
        }
        return instance;
    }
}

public class BankTest {

}