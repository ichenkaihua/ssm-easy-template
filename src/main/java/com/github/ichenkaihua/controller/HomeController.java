package com.github.ichenkaihua.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by chenkaihua on 15-12-15.
 */
@Controller
@RequestMapping("")
public class HomeController {


    @RequestMapping("index")
    public ModelAndView home(){
        return new ModelAndView("index");
    }


}
