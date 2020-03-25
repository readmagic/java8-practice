package oop.fun;

/**
 * Created by IntelliJ IDEA.
 * User: frandy
 * Date: 19-10-14
 * Time: 下午10:17
 */
@FunctionalInterface
public interface MyInterface {
    void test();
    static String hello(){
        return "你好世界";
    }

    default  String world(){
        return "整个默认实现尝尝";
    }
}
