package com.example.wx.appbackend.demo;

import java.util.*;

public class LambdaTest {
    public static void main(String[] args) {
//        List<Person> list = new ArrayList<>();
//        list.add(new Person(3));
//        list.add(new Person(6));
//        list.add(new Person(1));
//        Collections.sort(list, (o1,o2)-> o1.getAge()-o2.getAge());
//        list.size();
        Comparator<String> comparator = (String s1, String s2)-> s1.length() - s2.length();
        TestLambda t1 = (String s1, String s2)-> "" +s1.length() + s2.length();
//        TestLambda t1 = () -> "fun1";
//        TestLambda t2 = (String s1) -> s1;
        System.out.println(t1.fun2("s1","s2"));
    }
}

class Person{
    private int age;

    public Person(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

