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

class Spec {
    public List<Music> musics;

    public Spec(List<Music> musics) {
        this.musics = musics;
    }
}

class Music {
    public String name;
    public Double price;

    public Music(String name, Double price) {
        this.name = name;
        this.price = price;
    }
}

public class One_c {

    public static List<Spec> filter(Stream<Spec> specs) {
        return specs.filter(x -> x.musics.size() <= 3).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Spec> specs = new ArrayList<>();
        List<Music> musics = new ArrayList<>();
        musics.add(new Music("1",100.0));
        musics.add(new Music("2",120.0));
        musics.add(new Music("3",140.0));
        //musics.add(new Music("4",130.0));
        specs.add(new Spec(musics));
        filter(specs.stream()).forEach(System.out::println);
    }
}
