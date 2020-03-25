package oop.fun.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: frandy
 * Date: 19-10-31
 * Time: 下午3:43
 */
public class StreamTest4 {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("hello", "world");
        list.stream().map(x -> x).filter(x->true).forEach(System.out::println);
    }
}
