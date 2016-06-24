package com.google.gsonxml.test;

/**
 * Created by wangjw on 2016/6/24.
 */
public abstract class Person {

    private  int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract void eat();
}
