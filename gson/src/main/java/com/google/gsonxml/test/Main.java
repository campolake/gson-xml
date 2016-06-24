package com.google.gsonxml.test;

import com.google.gsonxml.GsonXml;

/**
 * Created by wangjw on 2016/6/24.
 */
public class Main {

    private  String name;




    public static void main(String[] args) throws IllegalAccessException {
        Student s = new Student();
        s.setAge(11);
        s.setName("90");
        Student.Scholl sc  = new Student.Scholl();
        sc.setClassz("sfsfsf");
        sc.setCnt(2);
        s.setS(sc);
        GsonXml gson  = new GsonXml();
        String xml= gson.toXml(s);
        System.out.println(xml);

//        Main main = new Main();
//        main.name = "wk";
//        Person p = main.createPerson("sf");
//        p.eat();
    }


    public Person createPerson(String nameStr)
    {
        final String name = nameStr;

        return new Person() {
            @Override
            public void eat() {
//                System.out.println(name);
                System.out.println(name);
            }
        };

    }


}
