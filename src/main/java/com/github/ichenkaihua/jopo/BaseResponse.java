package com.github.ichenkaihua.jopo;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.http.ResponseEntity;

/**
 * Created by dellidc on 2016/3/26.
 */
public class BaseResponse<T> {

    @ApiModelProperty()
    public T data;


    public String msg;

    public int code;


    public static <T> BaseResponse<T> buildResponse(int code, String msg, T data) {
        BaseResponse<T> baseResponse = new BaseResponse<T>();
        baseResponse.setCode(code);
        baseResponse.setData(data);
        baseResponse.setMsg(msg);
        return baseResponse;
    }


    public static <T> BaseResponse<T> buildSuccessResponse(T data) {
        return buildResponse(200, "访问成功", data);
    }


    public static <T> BaseResponse<T> buildFailResponse(int statusCode, String msg) {
        return buildResponse(statusCode, msg, null);
    }


    public ResponseEntity toResponseEntity() {
        return ResponseEntity.status(code).body(this);
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}