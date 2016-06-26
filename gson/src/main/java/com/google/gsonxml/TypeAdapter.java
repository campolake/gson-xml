package com.google.gsonxml;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by wangjw on 2016/6/24.
 */
public class TypeAdapter {

    private Map<String,BoundField> result = new LinkedHashMap<String,BoundField>();

    public Map<String,BoundField> getFields()
    {
        return result;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  TypeAdapter(Object src) throws IllegalAccessException {
        name  =  src.getClass().getSimpleName();
        getFields(src);
    }



    public Map<String,BoundField> getFields(Object obj) throws IllegalAccessException {
        Map<String,BoundField> innerResult = new LinkedHashMap<String,BoundField>();
        Class c = obj.getClass();
        Field[] fields = c.getDeclaredFields();
        for(Field f: fields)
        {
            Type filedType  = f.getType();
            Annotation[] as = f.getAnnotations();
            f.setAccessible(true);
            Object fieldValue = f.get(obj);
            boolean isAttribute = checkHaveAnnotation(as,XmlElementAttribute.class);
            BoundField bf  = createBoundField(fieldValue,filedType,f.getName(),isAttribute);
            result.put(f.getName(),bf);
        }
        return result;
    }


    private boolean checkHaveAnnotation(Annotation[] as,Type type)
    {
        if (as == null)
            return false;
        for(Annotation a:as)
        {
            if (a.annotationType() == type)
                return true;
        }
        return false;
    }

    private  BoundField createBoundField(Object value,Type type,String name,boolean isAttribute) throws IllegalAccessException {

        TypeAdapter typeAdapter = null;
        if (value.getClass().getClassLoader() != null)
        {
             typeAdapter  = new TypeAdapter(value);
        }
        return new BoundField(value,name,type,isAttribute,typeAdapter)
        {

        };
    }
}
