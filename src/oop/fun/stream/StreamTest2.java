package oop.fun.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * User: frandy
 * Date: 19-10-16
 * Time: 下午8:36
 */
public class StreamTest2 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello", "world");
        List<String> result = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        result.forEach(System.out::println);

        System.out.println("-------------");
        Stream<List<Integer>> stream = Stream.of(Arrays.asList(1, 2), Arrays.asList(3, 2), Arrays.asList(5, 3));
        stream.flatMap(List::stream).map(x -> x * x).forEach(System.out::println);
        System.out.println("-------------");

        int a=Stream.iterate(1, x -> x + 2)
                .limit(100)
                .filter(x -> x > 2)
                .mapToInt(x -> x * 2)
                .skip(2)
                .limit(2)
                .sum();
        System.out.println(a);

    }
}
