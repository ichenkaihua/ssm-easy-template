package com.github.ichenkaihua.service.impl;

import com.github.ichenkaihua.mapper.UserMapper;
import com.github.ichenkaihua.model.User;
import com.github.ichenkaihua.service.BaseService;
import com.github.ichenkaihua.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * Created by chenkaihua on 15-8-26.
 */
@Service("userService")
public class UserService extends BaseService<UserMapper,User,Integer> implements IUserService {




}
