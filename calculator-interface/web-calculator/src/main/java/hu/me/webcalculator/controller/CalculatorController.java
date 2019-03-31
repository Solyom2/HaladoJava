package hu.me.webcalculator.controller;

import hu.me.webcalculator.model.Input;
import hu.me.webcalculator.service.CalculatorServiceInterface;
import hu.me.webcalculator.service.impl.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

    private CalculatorService calculatorService;

    @Autowired
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showForm() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        mav.addObject("input", new Input(2, 3, "+"));
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView calculate(Input input, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();

        System.out.println(input.toString());

        if(bindingResult.hasErrors()) {
            mav.setViewName("index");
        }
        else {
            mav.addObject("result", calculatorService.calculate(input));
            mav.setViewName("result");
        }
        return mav;
    }

    @RequestMapping("/logs")
    public ModelAndView showLogs(CalculatorService calculatorService, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("logs");

        System.out.println(calculatorService.getLogs().size());

        //mav.addObject("logs", calculatorService.getLogs().size());
        return mav;
    }

}
