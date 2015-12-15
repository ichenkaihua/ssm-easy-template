package com.github.ichenkaihua.test.unit;

import com.github.ichenkaihua.model.User;
import com.github.ichenkaihua.service.UserService;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by chenkaihua on 15-9-15.
 */
public class UserServiceTest extends  BaseUnitTest{



    @Autowired
    UserService userService;


    @Test
    @Ignore
    public void test(){
        User user = new User();
        user.setName("陈开华");
        user.setPassword("密码");
        userService.addUser(user);
        System.out.println(user);
    }

}
