package hu.me.demo.controller;

import hu.me.demo.controller.dto.FirstParams;
import hu.me.demo.service.UserService;
import hu.me.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class CounterController {

    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, path="/")
    ModelAndView first(@Valid FirstParams firstParams, BindingResult bindingResult) {

        System.out.println(firstParams.toString());
        System.out.println(bindingResult.toString());

        ModelAndView mav = new ModelAndView();
        mav.addObject("age", firstParams.getAge());


        if(bindingResult.hasErrors()) {
            mav.setViewName("gyerek");
        }
        else mav.setViewName("felnott");

        return mav;
    }

}
