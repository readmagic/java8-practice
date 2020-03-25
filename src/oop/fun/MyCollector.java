package oop.fun;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Created by IntelliJ IDEA.
 * User: frandy
 * Date: 19-10-22
 * Time: 下午3:01
 */
public class MyCollector<T> implements Collector<T, Set<T>, Set<T>> {
    @Override
    public Supplier<Set<T>> supplier() {
        System.out.println("supplier invoked!");
        return HashSet::new;
    }

    @Override
    public BiConsumer<Set<T>, T> accumulator() {
        System.out.println("accumulator invoked! ");
        return Set::add;
    }

    @Override
    public BinaryOperator<Set<T>> combiner() {
        System.out.println("combiner invoked! ");
        return (set1, set2) -> {
            set1.addAll(set2);
            return set1;
        };
    }

    @Override
    public Function<Set<T>, Set<T>> finisher() {
        System.out.println("finisher invoked! ");
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        System.out.println("characteristics invoked! ");
        return Collections.unmodifiableSet(EnumSet.of(Collector.Characteristics.CONCURRENT,
                Collector.Characteristics.UNORDERED,
                Collector.Characteristics.IDENTITY_FINISH));
    }

    public static void main(String[] args) {
        List<String>list = Arrays.asList("a","b","c");
        Set<String>set = list.stream().sequential().collect(new MyCollector<>());
        System.out.println(set);
    }
}
