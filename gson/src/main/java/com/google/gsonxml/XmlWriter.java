package com.google.gsonxml;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by wangjw on 2016/6/24.
 */
public class XmlWriter implements Closeable, Flushable {


    private Writer writer;

    public XmlWriter(Writer writer) {
        this.writer = writer;
    }

    @Override
    public void close() throws IOException {
        if (writer != null)
            writer.close();
    }

    @Override
    public void flush() throws IOException {
        if (writer != null)
            writer.flush();
    }

    public void writeStartName(String name) throws IOException {
        writer.write("<");
        writer.write(name);
        writer.write(">");
    }

    public void writeEndName(String name) throws IOException {
        writer.write("</");
        writer.write(name);
        writer.write(">");
    }

    public void value(boolean value) throws IOException {
        writer.write(value ? "true" : "false");
    }

    public void value(Boolean value) throws IOException {
        writer.write(value ? "true" : "false");
    }

    public void value(int value) throws IOException {
        writer.write(value);
    }

    public void value(long value) throws IOException {
        writer.write(Long.toString(value));
    }

    public void value(double value) throws IOException {
        if (Double.isNaN(value) || Double.isInfinite(value)) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + value);
        }
        writer.write(Double.toString(value));
    }

    public void value(Number value) throws IOException {
        String string = value.toString();
        if ((string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN"))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + value);
        }
        writer.write(string);
    }

    public void value(String value) throws IOException {
        String str  = "";
        if (value != null)
            str = value;
        writer.write(str);
    }


}
