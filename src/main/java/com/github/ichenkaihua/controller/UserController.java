package com.github.ichenkaihua.controller;


import com.github.ichenkaihua.model.User;
import com.github.ichenkaihua.service.UserService;
import com.github.ichenkaihua.utils.URIUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import tk.mybatis.mapper.entity.Example;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RequestMapping("users")
@RestController
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;


    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    public ResponseEntity getUserBYId(@PathVariable int id){
        User user = userService.selectByPrimaryKey(id);
        if(user==null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody User user)  {

        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("name",user.getName());
        if (userService.selectCountByExample(example)>0) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        userService.insert(user);
        return ResponseEntity.created(URIUtils.createURI("users/{id}",user.getId())).body(user);

    }


    @RequestMapping(value = "",method =RequestMethod.GET )
    public ResponseEntity users(){
        List<User> users = userService.select(new User());
        return new ResponseEntity(users, HttpStatus.OK);
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
