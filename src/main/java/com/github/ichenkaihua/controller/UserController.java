package com.github.ichenkaihua.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RequestMapping("users")
@RestController
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

   /* @Autowired
    @Qualifier("userService")
    IUserService userService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public User getById(@PathVariable int id) {
        return userService.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<User> getList() {
        return userService.select(new User());
    }


    @RequestMapping(value = "",method = RequestMethod.POST)
    public int testInsert(@RequestBody User user){
        int insert = userService.insert(user);
        return user.getId();

    }*/


}
