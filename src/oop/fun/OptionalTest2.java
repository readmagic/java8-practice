package oop.fun;

import java.util.*;
import java.util.stream.Collectors;

/**
 * optional的推荐使用方式
 * Created by IntelliJ IDEA.
 * User: frandy
 * Date: 19-10-15
 * Time: 下午3:54
 */
public class OptionalTest2 {
    public static void main(String[] args) {
        School school = new School();
        List<Student> students = new ArrayList<>();
        students.add(new Student("frandy", 30));
        students.add(new Student("alice", 20));
        students.add(new Student("bob", 32));
        school.setStudents(students);
//        school.setStudents(null);
        Optional<School> optionalSchool = Optional.ofNullable(school);
        List<String> names = optionalSchool.map(x -> x.getStudents()).orElse(Collections.emptyList()).stream().map(x -> x.getName()).collect(Collectors.toList());
        names.forEach(System.out::println);
    }
}

class School {
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public School setStudents(List<Student> students) {
        this.students = students;
        return this;
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
