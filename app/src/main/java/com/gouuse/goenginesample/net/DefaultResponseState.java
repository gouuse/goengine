package com.gouuse.goenginesample.net;


import com.gouuse.goenginesample.constant.ResponseCode;

import java.util.List;

/**
 * @Description:
 * @author: <a href="http://xiaoyaoyou1212.360doc.com">DAWI</a>
 * @date: 2018/1/20 16:31
 */
public class DefaultResponseState implements IResponseState {
    @Override
    public int httpSuccess() {
        return ResponseCode.HTTP_SUCCESS;
    }

    @Override
    public int accessTokenExpired() {
        return ResponseCode.HTTP_SUCCESS;
    }

    @Override
    public int refreshTokenExpired() {
        return ResponseCode.HTTP_SUCCESS;
    }

    @Override
    public int otherPhoneLogin() {
        return ResponseCode.HTTP_SUCCESS;
    }

    @Override
    public int timestampError() {
        return ResponseCode.HTTP_SUCCESS;
    }

    @Override
    public int noAccessToken() {
        return ResponseCode.HTTP_SUCCESS;
    }

    @Override
    public int signError() {
        return ResponseCode.HTTP_SUCCESS;
    }

    @Override
    public List<Integer> otherError() {
        return null;
    }
}
