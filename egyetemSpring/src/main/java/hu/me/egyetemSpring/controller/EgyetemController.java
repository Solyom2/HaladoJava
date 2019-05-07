package hu.me.egyetemSpring.controller;

import hu.me.egyetemSpring.model.Egyetem;
import hu.me.egyetemSpring.model.Hallgato;
import hu.me.egyetemSpring.model.InputJSON;
import hu.me.egyetemSpring.service.EgyetemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class EgyetemController {

    private EgyetemService egyetemService;

    @Autowired
    public void setEgyetemService(EgyetemService egyetemService) {
        this.egyetemService = egyetemService;
    }

    @RequestMapping(value = "/addAdat", method = RequestMethod.POST)
    @ResponseBody
    public void addEgyetem(@RequestBody InputJSON inputJSON) {
        egyetemService.addAdat(inputJSON);
    }

}
