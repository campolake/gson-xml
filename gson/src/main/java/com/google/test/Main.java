package com.google.test;

import com.google.gson.Gson;
import com.google.gsonxml.test.Student;

/**
 * Created by wangjw on 2016/6/23.
 */
public class Main {
    public  static void main(String[] args)
    {
        Student s = new Student();
        s.setAge(11);
        s.setName("90");
        Student.Scholl sc  = new Student.Scholl();
        sc.setClassz("sfsfsf");
        sc.setCnt(2);
        s.setS(sc);
        Gson gson = new Gson();
        Class<?>  clazz = s.getClass();
        Class<?> df = clazz.getComponentType();
        String xml = gson.toJson(s);
        System.out.println(xml);
    }
}
