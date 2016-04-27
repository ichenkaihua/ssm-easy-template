package com.github.ichenkaihua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by chenkaihua on 15-12-15.
 */
@Controller
@RequestMapping("")
@ApiIgnore
public class HomeController {

    //首页跳转到api页面
    @RequestMapping("index")
    public ModelAndView home(){
        return new ModelAndView("redirect:swagger-ui.html");
    }


}
