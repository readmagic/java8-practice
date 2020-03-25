package oop.fun.stream;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by IntelliJ IDEA.
 * User: frandy
 * Date: 19-10-17
 * Time: 上午10:32
 */
public class StreamTest3 {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("张三", 20));
        students.add(new Student("张三", 40));
        students.add(new Student("李四", 24));
        students.add(new Student("王五", 23));
        Map<String, IntSummaryStatistics> x = students.stream().collect(Collectors.groupingBy(Student::getName,Collectors.summarizingInt(Student::getAge)));
        System.out.println(x);
        System.out.println("==================");
        Map<Boolean,List<Student>> ss = students.stream().collect(Collectors.partitioningBy(item->item.getAge()>30));
        System.out.println(ss.get(false));

        System.out.println("==================");
        students.stream().collect(Collectors.partitioningBy(z->z.getAge() >40,Collectors.partitioningBy(y->y.getAge()>60)));

    }
}

class Student {
    private String name;
    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public Student setAge(Integer age) {
        this.age = age;
        return this;
    }
}