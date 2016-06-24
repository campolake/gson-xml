package com.google.gsonxml.test;

/**
 * Created by wangjw on 2016/6/23.
 */
public class Student {

    private  Scholl S;

    public Scholl getS() {
        return S;
    }

    public void setS(Scholl s) {
        S = s;
    }

    public static class Scholl
    {
        private String classz;

        private int cnt;

        public String getClassz() {
            return classz;
        }

        public void setClassz(String classz) {
            this.classz = classz;
        }

        public int getCnt() {
            return cnt;
        }

        public void setCnt(int cnt) {
            this.cnt = cnt;
        }
    }
    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
