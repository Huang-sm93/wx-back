package com.wx.appbackend.createmodel.singleton;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2022/6/17
 */
public class LazySingleton {
    //懒汉单例模式
    //该模式的特点是类加载时没有生成单例，只有当第一次调用 getlnstance 方法时才去创建这个单例。
    private static volatile LazySingleton instance = null;

    public static synchronized LazySingleton getInstance(){
        if (instance == null){
            synchronized (LazySingleton.class){
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }

        }
        return instance;
    }
}
