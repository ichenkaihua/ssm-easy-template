package com.github.ichenkaihua.service;

import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

/**
 * Created by chenkaihua on 15-9-14.
 */
public class BaseMapperService<M,Map extends Mapper<M>> {


    @Autowired
    Map mapper;


    /**
     * 返回mapper
     * @return
     */
    public Map getMapper(){
        return mapper;
    }




}
