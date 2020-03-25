package oop.fun;

/**
 * Created by IntelliJ IDEA.
 * User: frandy
 * Date: 19-10-14
 * Time: 下午10:18
 */
public class Test2 {
    public static void main(String[] args) {

        hello(()-> System.out.println("测试效果"));
        System.out.println( MyInterface.hello());
        System.out.println(new ClassA().world());
    }


    private static void hello(MyInterface myInterface) {
        System.out.println("111111111");
        myInterface.test();
        System.out.println("2222222222");
    }

}
class ClassA implements MyInterface{
       @Override
       public void test() {
           System.out.println("hehehehhe");
       }

}