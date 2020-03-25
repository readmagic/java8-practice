package oop.fun.practice.ch6;

import java.util.Arrays;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: frandy
 * Date: 19-11-15
 * Time: 下午4:10
 */
public class A {

    public static int multiplyThrough(List<Integer> linkedListOfNumbers) {
        return linkedListOfNumbers.parallelStream()
                .reduce(1, (acc, x) -> x * acc) * 5;

    }

    public static void main(String[] args) {
        List<Integer> x = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        System.out.println(multiplyThrough(x));
    }
}
