package com.github.ichenkaihua.controller;


import com.github.ichenkaihua.model.User;
import com.github.ichenkaihua.service.UserService;
import com.github.ichenkaihua.utils.URIUtils;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RequestMapping(value = "users", produces = {APPLICATION_JSON_VALUE})
@RestController
@Api(value = "/users", tags = "用户信息", description = "用户信息")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;


    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    @ApiOperation(
            value = "根据id获取用户信息,不包含密码",
            response = User.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "无此用户"),
            @ApiResponse(code = 404,message = "无此用户2")
    })
    public ResponseEntity getUserBYId(@ApiParam(value = "用户id") @PathVariable int id) {
        User user = userService.getUserById(id);
        if (user == null) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "添加用户", code = 201, response = User.class, nickname = "mynickname")
    public ResponseEntity addUser(@RequestBody User user) {
        System.out.println(user.toString());
        User countUser = new User();
        countUser.setName(user.getName());
        //如果存在，返回错误码
        if (userService.isExist(countUser)) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        userService.addUser(user);
        return ResponseEntity.created(URIUtils.createURI("users/{id}", user.getId())).body(user);

    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity users() {
        List<User> users = userService.getUsers(null);
        return new ResponseEntity(users, HttpStatus.OK);
    }


    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void deleteById(@PathVariable int id) {
        userService.deleteById(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void update(@RequestBody User user) {
        userService.update(user);
    }


}
