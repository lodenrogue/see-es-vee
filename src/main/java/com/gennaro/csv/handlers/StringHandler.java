package com.gennaro.csv.handlers;

import java.lang.reflect.Field;

public class StringHandler extends Handler{

    @Override
    public void handleRead(String value, Object object, Field field) throws IllegalAccessException {
        this.setSafely(value.length() < 1 ? null : value, object, field);
    }

    @Override
    public String handleWrite(Object object, Field field) throws IllegalAccessException {
        return (String) getSafely(object, field);
    }

}
