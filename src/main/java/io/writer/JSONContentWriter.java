package io.writer;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class JSONContentWriter implements ContentWriter {

    @Override
    public String write(Object object) {
        Gson obj = new Gson();
        return obj.toJson(object);
    }

}
