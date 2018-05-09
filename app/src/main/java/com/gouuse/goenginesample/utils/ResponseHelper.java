package com.gouuse.goenginesample.utils;


import com.gouuse.goenginesample.constant.ResponseCode;
import com.gouuse.goenginesample.engine.HttpStatus;

/**
 * Created by reiserx on 2018/4/2.
 * desc : 相应帮助类
 */
public class ResponseHelper {

    public static boolean isSuccess(HttpStatus apiResult) {
        if (apiResult == null) {
            return false;
        }
        return apiResult.getCode() == ResponseCode.HTTP_SUCCESS;
    }

}
