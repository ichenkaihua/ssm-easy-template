package com.github.ichenkaihua.service;

import com.github.ichenkaihua.mapper.UserMapper;
import com.github.ichenkaihua.model.User;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Service;

/**
 * Created by chenkaihua on 15-9-15.
 */
@Service
public class UserService extends BaseService<UserMapper, User> {



    @RequiresRoles("admin")
    public void deleteWithAdminRoleById(int id){


            mapper.deleteByPrimaryKey(id);

    }



}
