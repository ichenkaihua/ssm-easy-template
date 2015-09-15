package com.github.ichenkaihua.controller;


import com.github.ichenkaihua.model.User;
import com.github.ichenkaihua.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("users")
@RestController
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;


    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public User getUserBYId(@PathVariable int id){
        return userService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public User addUser(@RequestParam String name,@RequestParam String password){
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        userService.insert(user);
        return user;
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    public void deleteById(@PathVariable int id){
        userService.deleteByPrimaryKey(id);
    }

    @RequestMapping
    public void update(@RequestBody User user){
        userService.updateByPrimaryKeySelective(user);
    }











}
