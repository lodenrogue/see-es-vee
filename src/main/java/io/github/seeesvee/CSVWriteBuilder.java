package io.github.seeesvee;

import io.github.seeesvee.handlers.Handler;

import java.util.ArrayList;
import java.util.HashMap;

public final class CSVWriteBuilder<T> {

    private String delimiter = ",";
    private HashMap<Class<?>, ArrayList<Handler>> handlers = new HashMap<>();
    private Class<T> clazz;

    public CSVWriteBuilder(){ }

    public CSVWriter<T> create(){

        if(this.handlers.size() == 0) handlers = null;
        return new CSVWriter<T>(delimiter, handlers, clazz);
    }

    public CSVWriteBuilder<T> setDelimiter(String s){
        this.delimiter = s;
        return this;
    }
    public CSVWriteBuilder<T> addHandler(Class<?> clazz, Handler handler){
        if(!this.handlers.containsKey(clazz)){
            this.handlers.put(clazz, new ArrayList<>());
        }
        this.handlers.get(clazz).add(handler);
        return this;
    }
    public CSVWriteBuilder<T> setClass(Class<T> clazz){
        this.clazz = clazz;
        return this;
    }

}