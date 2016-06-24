package com.google.gsonxml;

import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by wangjw on 2016/6/24.
 */
public class GsonXml {

    TypeAdapter typeAdapter;

    public GsonXml()
    {
        typeAdapter = new TypeAdapter();
    }


    public String toXml(Object obj) throws IllegalAccessException {
        if (null == obj)
            return "";
        return toXml(obj,obj.getClass());
    }

    public String toXml(Object obj,Type classz) throws IllegalAccessException {
        StringWriter writer = new StringWriter();
        toXml(obj, classz, writer);
        return writer.toString();
    }



    public  void toXml(Object src, Type classz, Writer writer) throws IllegalAccessException {
        XmlWriter xmlWriter = new XmlWriter(writer);
        ElementWriter elementWriter = new ElementWriter(xmlWriter);
        typeAdapter.reflectClass(src);
        Map<String,BoundField> result = typeAdapter.getFields();
    }
}
