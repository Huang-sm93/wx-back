package com.wx.appbackend.study;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2023/7/14
 */
public class PrincipleMode {
    public static void main(String[] args) {
        Product product = new ProductBuild().setColor("红色").setName("产品1").setPrice("100").setSize("大").setType("类型1").build();
        System.out.println(product.color);
    }
}


//建造者模式
class Builder{
    private ProductBuilder productBuilder;
    public void setProductBuilder(ProductBuilder productBuilder){
        this.productBuilder = productBuilder;
    }

    public Product getProduct(){
        return productBuilder.build();
    }

    public void buildProduct(){
        productBuilder.buildProduct();
        productBuilder.buildName();
        productBuilder.buildType();
        productBuilder.buildColor();
        productBuilder.buildSize();
        productBuilder.buildPrice();
    }

}

class AProductBuilder extends ProductBuilder {
    @Override
    public void buildName() {
        product.name = "A产品";
    }

    @Override
    public void buildType() {
        product.type = "A类型";
    }

    @Override
    public void buildColor() {
        product.color = "A颜色";
    }

    @Override
    public void buildSize() {
        product.size = "A大小";
    }

    @Override
    public void buildPrice() {
        product.price = "A价格";
    }
}

class ProductBuild{
    private Product product;

    public ProductBuild(){
        this.product = new Product();
    }

    public ProductBuild setName(String name){
        product.name = name;
        return this;
    }

    public ProductBuild setType(String type){
        product.type = type;
        return this;
    }

    public ProductBuild setColor(String color){
        product.color = color;
        return this;
    }

    public ProductBuild setSize(String size){
        product.size = size;
        return this;
    }

    public ProductBuild setPrice(String price){
        product.price = price;
        return this;
    }

    public Product build(){
        return product;
    }
}
class Product{
    public String name;
    public String type;
    public String color;
    public String size;
    public String price;
}

abstract class ProductBuilder{
    protected Product product;

    public void buildProduct(){
        product = new Product();
    }

    public abstract void buildName();
    public abstract void buildType();
    public abstract void buildColor();
    public abstract void buildSize();
    public abstract void buildPrice();

    public Product build(){
        return product;
    }
}




//单例模式
class Singleton {
    //new一个对象的代码是无法保证顺序性的，因此，我们需要使用另一个关键字volatile保证对象实例化过程的顺序性。
    private static volatile Singleton instance = null;

    private Singleton() {
    }

    // 懒加载非线程安全
//    public static Singleton getInstance() {
//        if (instance == null)
//            instance = new Singleton();
//        return instance;
//    }

    //线程安全，但是每次都要加锁，效率低
//    public static synchronized Singleton getInstance() {
//        if (instance == null)
//            instance = new Singleton();
//        return instance;
//    }

    //线程安全，只有判断为空的时候才加锁，效率高
//    public static Singleton getInstance() {
//        if (instance == null)
//            synchronized (instance) {
//                if (instance == null)
//                    instance = new Singleton();
//            }
//        return instance;
//    }

    private static class SingletonHolder {
        private static final Singleton INSTANCE = new Singleton();
    }

    // 静态内部类的方式获取单例，jvm保证线程安全
    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}

abstract class AbstractProductFactory{
    abstract Product createProduct();
}