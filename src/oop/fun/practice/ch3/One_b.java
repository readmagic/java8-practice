package oop.fun.practice.ch3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by IntelliJ IDEA.
 * User: frandy
 * Date: 19-11-12
 * Time: 上午11:47
 */
class Artist {
    public String name;
    public String country;
    public Integer age;

    public Artist(String name, String country, Integer age) {
        this.name = name;
        this.country = country;
        this.age = age;
    }
}


public class One_b {
    public static List<String> map(Stream<Artist> artistStream) {
        return artistStream.map(x -> x.name + ":" + x.country).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Artist> artists = new ArrayList<>();
        artists.add(new Artist("张三", "法国", 24));
        artists.add(new Artist("李四", "中国", 32));
        artists.add(new Artist("王五", "英国", 43));
        map(artists.stream()).forEach(System.out::println);
    }

}
