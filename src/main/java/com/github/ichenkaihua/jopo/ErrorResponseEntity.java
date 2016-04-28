package com.github.ichenkaihua.jopo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by dellidc on 2016/4/28.
 */
@ApiModel(description = "客户端ErrorResponseEntity,有返回msg和errorCode")
public class ErrorResponseEntity {
    @ApiModelProperty(value = "提示信息",required = true)
    public String msg;
    @ApiModelProperty(value = "错误码",allowableValues = "0,1,2",required = true)
    public int errorCode;


    public ErrorResponseEntity( int errorCode,String msg) {
        this.msg = msg;
        this.errorCode = errorCode;
    }

    public  ResponseEntity toResponseEntity(){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(this);
    }


}
