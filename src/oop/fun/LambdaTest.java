package oop.fun;

/**
 * Created by IntelliJ IDEA.
 * User: frandy
 * Date: 19-11-7
 * Time: 下午3:25
 */
public class LambdaTest {

    //这里的this表示当前的类
    Runnable r1 = () -> System.out.println(this);
    Runnable r2 = new Runnable() {
        @Override
        public void run() {
            //这里的this表示匿名内部类
            System.out.println(this);
        }
    };

    public static void main(String[] args) {
        LambdaTest lambdaTest = new LambdaTest();
        Thread t1= new Thread(lambdaTest.r1);
        t1.start();
        Thread t2 = new Thread(lambdaTest.r2);
        t2.start();
    }

}
