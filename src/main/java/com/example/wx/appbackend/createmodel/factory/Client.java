package com.example.wx.appbackend.createmodel.factory;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2022/6/17
 */
public class Client {
    public static void main(String[] args) {
        //简单工厂
        //工厂类包含必要的逻辑判断，可以决定在什么时候创建哪一个产品的实例。客户端可以免除直接创建产品对象的职责，很方便的创建出相应的产品。工厂和产品的职责区分明确。
        //但是违背了开闭原则，增加产品的时候需要修改工厂类的代码
        SimpleFactory.createProduct(1).show();
        SimpleFactory.createProduct(2).show();
        //工厂方法
        //用户只需要知道工厂类的名称 就可以构建出产品
        //灵活性增强，对于新产品的创建，只需多写一个相应的工厂类。
        //类的个数容易过多，增加复杂度
        new ConcreteFactory1().getPhone().show();
        new ConcreteFactory2().getPhone().show();

        //抽象工厂方法
        new ConcreteFactory1().getBook().show();
        new ConcreteFactory2().getBook().show();
        new ConcreteFactory1().getPhone().show();
        new ConcreteFactory2().getPhone().show();
    }
}
