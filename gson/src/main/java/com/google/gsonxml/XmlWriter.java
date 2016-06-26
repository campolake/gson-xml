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

    private String encoding;

    public XmlWriter(Writer writer,String code)
    {
        this.writer = writer;
        this.encoding = code;
    }

    @Override
    public void close() throws IOException {
        if (writer != null)
            writer.close();
    }

    public void writeHead() throws IOException {
        writer.write("<?xml version=\"1.0\" encoding=\"");
        writer.write(encoding);
        writer.write("\"?>");
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
}
