package com.wx.appbackend.study.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/2/1
 */
public class MainTest {

    public static void main(String[] args) throws Exception {
//        //获取ReflectionDemo类Class对象
//        //方式1
//        Class class1 = Class.forName("com.wx.appbackend.study.reflection.ReflectionDemo");
////        //方式2
////        Class class2 = ReflectionDemo.class;
////        //方式3
////        ReflectionDemo demo = new ReflectionDemo();
////        Class class3 = demo.getClass();
////        System.out.println("class1 = " + class1 + "\n" +
////                "class2 = " + class2 + "\n" +
////                "class3 = " + class3 + "\n" +
////                "class1 == class2 ? " + (class1 == class2) + "\n" +
////                "class2 == class3 ? " + (class2 == class3));
//
//        // 获取字段有两个 API：getDeclaredFields和getFields。
//        // 他们的区别是:getDeclaredFields用于获取所有声明的字段，包括公有字段和私有字段，getFields仅用来获取公有字段
//        Field[] publicFields = class1.getFields();
//        for (Field field : publicFields) {
//            System.out.println(field);
//        }
//
//        Field[] allFields = class1.getDeclaredFields();
//        for (Field field : allFields) {
//            System.out.println(field);
//        }
//
//        // 获取构造方法同样包含了两个 API：
//        // 用于获取所有构造方法的 getDeclaredConstructors和用于获取公有构造方法的getConstructors
//        Constructor[] publicConstructors = class1.getConstructors();
//        for (Constructor constructor : publicConstructors) {
//            System.out.println(constructor);
//        }
//
//        Constructor[] allConstructors = class1.getDeclaredConstructors();
//        for (Constructor constructor : allConstructors) {
//            System.out.println(constructor);
//        }
//
//        //获取非构造方法的两个 API 是：
//        // 获取所有声明的非构造函数的 getDeclaredMethods 和仅获取公有非构造函数的 getMethod
//
//        Method[] publicMethods = class1.getMethods();
//        for (Method method : publicMethods) {
//            System.out.println(method);
//        }
//
//        Method[] allMethods = class1.getDeclaredMethods();
//        for (Method method : allMethods) {
//            System.out.println(method);
//        }


        /** 1.通过字符串获取Class对象，这个字符串必须带上完整路径名 */
        Class testClass = Class.forName("com.wx.appbackend.study.reflection.ReflectionDemo");
        // 2.获取声明的构造方法，传入所需参数的类名，如果有多个参数，用','连接即可

        Constructor constructor1 = testClass.getConstructor();
        Object o = constructor1.newInstance();

        Constructor constructor = testClass.getDeclaredConstructor(String.class);
        // 如果是私有的构造方法，需要调用下面这一行代码使其可使用，公有的构造方法则不需要下面这一行代码
//        studentConstructor.setAccessible(true);
        // 使用构造方法的newInstance方法创建对象，传入构造方法所需参数，如果有多个参数，用','连接即可
        Object student = constructor.newInstance("NameA");
// 3.获取声明的字段，传入字段名
        Field field = testClass.getDeclaredField("anInt");
//        field.getAnnotation();
// 如果是私有的字段，需要调用下面这一行代码使其可使用，公有的字段则不需要下面这一行代码
// studentAgeField.setAccessible(true);
// 使用字段的set方法设置字段值，传入此对象以及参数值
//        studentAgeField.set(student,10);
// 4.获取声明的函数，传入所需参数的类名，如果有多个参数，用','连接即可
        Method studentShowMethod = testClass.getDeclaredMethod("show",String.class);
// 如果是私有的函数，需要调用下面这一行代码使其可使用，公有的函数则不需要下面这一行代码
        studentShowMethod.setAccessible(true);
// 使用函数的invoke方法调用此函数，传入此对象以及函数所需参数，如果有多个参数，用','连接即可。函数会返回一个Object对象，使用强制类型转换转成实际类型即可
        Object result = studentShowMethod.invoke(student,"message");
        System.out.println("result: " + result);
    }
}
