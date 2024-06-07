package com.wx.appbackend.study.reflect;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/9/20
 */
public class ReflectDemo1 {
    public static void main(String[] args) {
        ReflectClassDemo<String> reflectClassDemo = new ReflectClassDemo<>();
        reflectClassDemo.setTValue("Hello World!");
        System.out.println(reflectClassDemo.getTValue());

        ReflectClassDemo2<String, Integer> reflectClassDemo2 = new ReflectClassDemo2<>("Hello World!", 100);
        reflectClassDemo2.show();

        ReflectInterfaceDemoImpl<Integer> reflectInterfaceDemoImpl = new ReflectInterfaceDemoImpl();
        reflectInterfaceDemoImpl.setT(1);
        System.out.println(reflectInterfaceDemoImpl.getT());

        ReflectMethodDemo1 reflectMethodDemo1 = new ReflectMethodDemo1();
        System.out.println(reflectMethodDemo1.show("Hello World!"));
    }
}

class ReflectMethodDemo1<T>{
    //必须用<T>来声明泛型方法
    public <T> T show(Object t){
        return (T)t;
    }
}

class ReflectClassDemo<T>{
    private T t;

    public void setTValue(T t){
        this.t = t;
    }

    public T getTValue(){
        return t;
    }
}

class ReflectClassDemo2<K, V>{
    private K name;
    private V age;

    public ReflectClassDemo2() {
    }

    public ReflectClassDemo2(K name, V age) {
        this.name = name;
        this.age = age;
    }

    public void show(){
        System.out.println("name = " + name + ", age = " + age);
    }
}

interface ReflectInterfaceDemo<T>{
    public void setT(T t);

    public T getT();
}

class ReflectInterfaceDemoImpl<T> implements ReflectInterfaceDemo<T>{
    private T t;

    @Override
    public void setT(T t) {
        this.t = t;
    }

    @Override
    public T getT() {
        return this.t;
    }
}