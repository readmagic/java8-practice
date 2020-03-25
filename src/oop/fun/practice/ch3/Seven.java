package oop.fun.practice.ch3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 在一个字符串列表中，找出包含最多小写字母的字符串。对于空列表，返回 Optional<String> 对象
 * Created by IntelliJ IDEA.
 * User: frandy
 * Date: 19-11-13
 * Time: 下午4:18
 */
public class Seven {

    public static long countLowercaseLetters(String str) {
        return str.chars().filter(x -> x >= 97 && x <= 122).count();
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("dsandsandsabASbdsads", "dsadsa", "ADSADSADSA", "dsadsaJDSAKJBDSKJBN");
        String x = strings.stream().max(Comparator.comparingLong(Seven::countLowercaseLetters)).orElse("");
        System.out.println(x);

    }
}
