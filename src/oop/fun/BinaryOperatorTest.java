package oop.fun;

import java.util.Comparator;
import java.util.function.BinaryOperator;

/**
 * Created by IntelliJ IDEA.
 * User: frandy
 * Date: 19-10-15
 * Time: 下午3:06
 */
public class BinaryOperatorTest {
    public static void main(String[] args) {
        Comparator<String> comparator = Comparator.comparingInt(a -> a.charAt(0));
        System.out.println(BinaryOperator.minBy(comparator).apply("hello", "world"));
    }
}
