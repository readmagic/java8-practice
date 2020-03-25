package oop.fun;

import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * User: frandy
 * Date: 19-10-15
 * Time: 下午3:18
 */
public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("hello");
        optional.ifPresent((x)-> System.out.println(x));
    }
}
