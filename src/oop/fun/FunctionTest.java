package oop.fun;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;

/**
 * Created by IntelliJ IDEA.
 * User: frandy
 * Date: 19-10-15
 * Time: 上午10:14
 */
public class FunctionTest {
    public static void main(String[] args) {
        FunctionTest test = new FunctionTest();
        Function<Integer, Integer> function1 = value -> {
            System.out.println("执行了方法1");
            return 2 * value;
        };
        Function<Integer, Integer> function2 = value -> {
            System.out.println("执行了方法2");
            return 3 * value;
        };
        Function<Integer, Integer> function3 = value -> {
            System.out.println("执行了方法3");
            return 3 * value;
        };
        System.out.println(test.compute(1, function1.andThen(function2).andThen(function3)));
        System.out.println("=====================================");
        System.out.println(test.compute2(2,3,(value1,value2)->value1+value2));
        System.out.println("=====================================");

        System.out.println(test.compute3(5,6,(value1,value2)->value1+value2));
    }

    public int compute(int a, Function<Integer, Integer> function) {
        int result = function.apply(a);
        return result;
    }

    public int compute2(int a, int b, BiFunction<Integer,Integer,Integer> biFunction){
        return biFunction.apply(a,b);
    }

    public int compute3(int a, int b, BinaryOperator<Integer> binaryOperator){
        return binaryOperator.apply(a,b);
    }

}
