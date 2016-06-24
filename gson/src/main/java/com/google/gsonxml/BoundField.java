package com.google.gsonxml;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjw on 2016/6/24.
 */
public abstract class BoundField {

    private Object value;
    private Type type;
    private  boolean isAttribute;

    public BoundField(Object value,Type type,boolean isAttribute)
    {
        this.value = value;
        this.type = type;
        this.isAttribute = isAttribute;
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
