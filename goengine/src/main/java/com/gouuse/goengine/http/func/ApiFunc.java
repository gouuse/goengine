package com.gouuse.goengine.http.func;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;

import io.reactivex.functions.Function;
import okhttp3.ResponseBody;


/**
 * Created by reiserx on 2018/3/29.
 * desc :ResponseBody转T
 */
public class ApiFunc<T> implements Function<ResponseBody, T> {
    private Type type;

    public ApiFunc(Type type) {
        this.type = type;
    }

    @Override
    public T apply(ResponseBody responseBody) throws Exception {
        Gson gson = new Gson();
        String json;
        try {
            json = responseBody.string();
            if (type.equals(String.class)) {
                return (T) json;
            } else {
                return gson.fromJson(json, type);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            responseBody.close();
        }
        return null;
    }
}
