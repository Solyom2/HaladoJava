package hu.me.demo.controller;

import hu.me.demo.controller.dto.User;
import hu.me.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/counter")
public class CounterController {

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    ModelAndView first() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        mav.addObject("user", new User(0, "name", 2));

        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    ModelAndView post(@Valid User user, BindingResult bindingResult) {

        System.out.println(user.toString());
        System.out.println(bindingResult.toString());

        ModelAndView mav = new ModelAndView();
        mav.addObject("age", user.getAge());

        if(bindingResult.hasErrors()) {
            mav.setViewName("index");
        }
        else {
            mav.setViewName("felnott");
        }

        return mav;
    }

}
