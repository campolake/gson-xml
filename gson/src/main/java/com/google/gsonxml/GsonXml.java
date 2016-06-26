package com.google.gsonxml;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.Map;

/**
 * Created by wangjw on 2016/6/24.
 */
public class GsonXml {



    public GsonXml()
    {

    }


    public String toXml(Object obj) throws IllegalAccessException, IOException {
        if (null == obj)
            return "";
        return toXml(obj,obj.getClass());
    }

    public String toXml(Object obj,Type classz) throws IllegalAccessException, IOException {
        StringWriter writer = new StringWriter();
        toXml(obj, classz, writer);
        return writer.toString();
    }



    public  void toXml(Object src, Type classz, Writer writer) throws IllegalAccessException, IOException {
        TypeAdapter typeAdapter = new TypeAdapter(src);
        XmlWriter xmlWriter = new XmlWriter(writer,"UTF-8");
        ElementWriter elementWriter = new ElementWriter(xmlWriter);
        Map<String,BoundField> result = typeAdapter.getFields();
        String name = typeAdapter.getName();
        xmlWriter.writeHead();
        xmlWriter.write("<");
        xmlWriter.write(name.toUpperCase());
        xmlWriter.write(" TYPE=\"REQUEST\"");
        xmlWriter.write(">");
        for(BoundField bf : result.values())
        {
            bf.write(xmlWriter);
        }
        xmlWriter.writeEndName(name.toUpperCase());
    }
}
