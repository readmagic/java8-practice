package oop.fun.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * User: frandy
 * Date: 19-10-16
 * Time: 下午3:39
 */
public class StreamTest1 {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("hello", "world", "helloWorld");
        String[] stringArray = stream.toArray(String[]::new);
        Arrays.asList(stringArray).forEach(System.out::println);

    }
}
