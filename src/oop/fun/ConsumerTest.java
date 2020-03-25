package oop.fun;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

/**
 * Created by IntelliJ IDEA.
 * User: frandy
 * Date: 19-10-30
 * Time: 下午3:07
 */
public class ConsumerTest {
    public static void main(String[] args) {
        Consumer<Integer> t = (a) -> System.out.println(a);
        IntConsumer x = a-> System.out.println(a);
        test(t);//面向对象的传递方式
        test(t::accept);//函数式的传递方式
        test(x::accept);//函数式的传递方式
    }


    public static void test(Consumer<? super Integer> action) {
        if (action instanceof IntConsumer) {
            System.out.println("1");
        } else {
            IntConsumer n = action::accept;
            n.accept(4);
            System.out.println("2");
        }
    }
}
