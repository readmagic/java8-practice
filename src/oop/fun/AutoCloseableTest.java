package oop.fun;

/**
 * Created by IntelliJ IDEA.
 * User: frandy
 * Date: 19-10-29
 * Time: 下午4:30
 */
public class AutoCloseableTest implements AutoCloseable {
    public void test(){
        System.out.println("test");
    }

    @Override
    public void close() throws Exception {
        System.out.println("close invoked");
    }

    public static void main(String[] args) throws Exception {
        try(AutoCloseableTest autoCloseableTest = new AutoCloseableTest()){
            autoCloseableTest.test();
        }
    }
}
