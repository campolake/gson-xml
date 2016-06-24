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

    private 

    public  TypeAdapter()
    {

    }

    public void reflectClass(Object object) throws IllegalAccessException {
        Class c = object.getClass();
        Field[] fields = c.getDeclaredFields();
        for(Field f: fields)
        {
            Type filedType  = f.getType();
            Annotation[] as = f.getAnnotations();
            f.setAccessible(true);
            Object fieldValue = f.get(object);
            boolean isAttribute = checkHaveAnnotation(as,XmlElementAttribute.class);
            BoundField bf  = createBoundField(fieldValue,filedType,isAttribute);
            result.put(f.getName(),bf);
        }
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

    private  BoundField createBoundField(Object value,Type type,boolean isAttribute)
    {
        return new BoundField(value,type,isAttribute)
        {

        };
    }
}
