package oop.fun.methodReference;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用的4种形式
 * Created by IntelliJ IDEA.
 * User: frandy
 * Date: 19-10-15
 * Time: 下午4:47
 */
public class MethodReferenceTest {
    public String getString(String a, Function<String, String> function) {
        return function.apply(a);
    }

    public String getString(Supplier supplier) {
        return supplier.get() + "test";
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("frandy", 100));
        students.add(new Student("alice", 80));
        students.add(new Student("bob", 93));
        students.add(new Student("tom", 60));


        //lambda方式调用
        //students.sort((a, b) -> Student.compareStudentByScore(a, b));
        //students.forEach(x -> System.out.println(x.getScore()));

        //方法引用----通过 类名::静态方法 调用
        // students.sort(Student::compareStudentByScore);
        // students.forEach(x -> System.out.println(x.getScore()));

        //lambda方式调用
//        StudentComparator studentComparator = new StudentComparator();
//        students.sort((a, b) -> studentComparator.compareByScore(a, b));
//        students.forEach(x -> System.out.println(x.getScore()));

        //方法引用----通过 对象名::实例方法 调用
        //students.sort(studentComparator::compareStudentByScore);
        //students.forEach(x -> System.out.println(x.getScore()));

        //方法引用----通过  类名::实例方法 调用
//        students.sort(Student::compareByScore);
//        students.forEach(x -> System.out.println(x.getScore()));

        //方法引用---- 构造器引用 类名::new
        MethodReferenceTest methodReferenceTest = new MethodReferenceTest();
        System.out.println(methodReferenceTest.getString("hello", String::new));
        System.out.println(methodReferenceTest.getString(String::new));

    }


}

class Student {
    private String name;
    private Integer score;

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Student setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getScore() {
        return score;
    }

    public Student setScore(Integer score) {
        this.score = score;
        return this;
    }

    public static int compareStudentByScore(Student a, Student b) {
        return a.score - b.score;
    }

    public int compareByScore(Student student) {
        return this.getScore() - student.getScore();
    }

}

class StudentComparator {
    public int compareByScore(Student a, Student b) {
        return a.getScore() - b.getScore();
    }
}
