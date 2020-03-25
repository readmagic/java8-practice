package oop.fun;

import java.util.function.Supplier;

/**
 * Created by IntelliJ IDEA.
 * User: frandy
 * Date: 19-10-15
 * Time: 下午2:38
 */
public class SupplierTest {
    public static void main(String[] args) {
        Supplier<String> supplier = ()->"hello";
        System.out.println(supplier.get());
    }
}
