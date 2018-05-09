package com.gouuse.goenginesample.engine;

/**
 * Created by reiserx on 2017/6/2.
 * desc :网络请求返回的基础类
 *
 * @param <T> data
 */

public class HttpStatus<T> {
    /**
     * 请求状态码
     */
    private int code;
    /**
     * 提示信息
     */
    private String msg;
    /**
     * 返回数据
     */
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return msg;
    }

    public void setMessage(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "ApiResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

}
