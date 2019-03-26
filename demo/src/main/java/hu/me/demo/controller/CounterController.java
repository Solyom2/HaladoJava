package hu.me.demo.controller;

import hu.me.demo.service.UserService;
import hu.me.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CounterController {

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, path="/")
    ModelAndView first(@RequestParam() Integer age) {

        ModelAndView mav = new ModelAndView();

        mav.addObject("age", age);
        if(userService.isAdult(age)){
            mav.setViewName("felnott");
        }
        else mav.setViewName("gyerek");

        return mav;
    }

}
