package oop.fun.practice.ch3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * User: frandy
 * Date: 19-11-12
 * Time: 上午11:47
 */
public class One_a {

    public static int addUp(Stream<Integer> numbers) {
        return numbers.reduce(0, (a, b) -> a + b);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        System.out.println(addUp(list.stream()));
    }
}
