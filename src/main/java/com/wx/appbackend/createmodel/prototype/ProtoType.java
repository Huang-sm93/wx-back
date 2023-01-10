package com.wx.appbackend.createmodel.prototype;

/**
 * Created by Intellij IDEA.
 * User:  sm.huang
 * Date:  2022/6/17
 */
public class ProtoType implements Cloneable{
    private String name;
    private Cat cat;
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public ProtoType clone() throws CloneNotSupportedException {
        ProtoType protoType = (ProtoType) super.clone();
        protoType.setCat(protoType.cat.clone());
        return protoType;
    }
}
