package multithread.runnable;

/**
 * 创建多线程方式二：实现Runnable接口
 *      1、创建一个实现Runnbale接口的类
 *      2、实现Runnbale中的抽象方法：run
 *      3、创建实现类的对象
 *      4、将此对象通过参数传给Thread类的构造器，创建Thread类的对象
 *      5、通过Thread类的对象调用start()
 *              Thread中的run方法为      run(){
 *                                         if(target !=null)
 *                                              target.run()
 *                                      }
 *              Thread中通过  new Thread(Runnbale target) 初始化private Runnable target
 *              所以通过Thread的对象调用的是Runable实现类中的run方法
 *
 *
 *  Thread也实现了Runnbale接口，且继承Thread的方式，有局限性，开发中一般使用实现Runnable接口
 *
 *
 *
 */

//1、创建一个实现Runnbale接口的类
class MyRunnbale implements Runnable{

    //2、实现Runnbale中的抽象方法：run
    @Override
    public void run() {
        for (int i = 0;i<1001;i++){
            if (i % 2 == 0){
                System.out.println(i);
            }
        }
    }
}
public class RunnableTest01 {
    public static void main(String[] args) {
        //3、创建实现类的对象
        MyRunnbale myRunnbale = new MyRunnbale();
        //4、将此对象通过参数传给Thread类的构造器，创建Thread类的对象
        Thread thread1 = new Thread(myRunnbale);
        //5、通过Thread类的对象调用start()

        thread1.start();
    }
}
