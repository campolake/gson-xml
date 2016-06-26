package com.google.gsonxml;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wangjw on 2016/6/24.
 */
public abstract class BoundField {

    private Object value;
    private  String name;
    private Type type;
    private  boolean isAttribute;
    TypeAdapter typeAdapter;

    public  void write(XmlWriter writer) throws IOException {
        writer.writeStartName(name.toUpperCase());
        if (typeAdapter != null) {
            Map<String, BoundField> result = typeAdapter.getFields();
            if(result != null) {
                for (BoundField bf : result.values()) {
                    bf.write(writer);
                }
            }
        }
        else
        {
            writer.write(value.toString());
        }
        writer.writeEndName(name.toUpperCase());
    }


    public BoundField(Object value,String name,Type type,boolean isAttribute,TypeAdapter ada)
    {
        this.value = value;
        this.name = name;
        this.type = type;
        this.isAttribute = isAttribute;
        this.typeAdapter = ada;
    }

    public BoundField(Object value,String name,Type type,boolean isAttribute)
    {
        this.value = value;
        this.name = name;
        this.type = type;
        this.isAttribute = isAttribute;
    }

    public  void setTypeAdapter(TypeAdapter ada)
    {
        typeAdapter = ada;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public boolean isAttribute() {
        return isAttribute;
    }

    public void setAttribute(boolean attribute) {
        isAttribute = attribute;
    }


}
