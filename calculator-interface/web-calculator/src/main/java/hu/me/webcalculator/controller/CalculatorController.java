package hu.me.webcalculator.controller;

import hu.me.webcalculator.model.Input;
import hu.me.webcalculator.service.impl.CalculatorService;
import hu.me.webcalculator.service.impl.InputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;

@Controller
public class CalculatorController {

    private CalculatorService calculatorService;
    private InputValidator inputValidator;

    @Autowired
    public void setCalculatorService(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @Autowired
    public void setInputValidator(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    @ModelAttribute("operators")
    public ArrayList<String> listOperator() {
        ArrayList<String> operators = new ArrayList<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");
        return operators;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(inputValidator);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView showForm() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("index");
        mav.addObject("input", new Input(0, 0, ""));
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView calculate(@ModelAttribute("input") @Valid Input input, BindingResult bindingResult) {
        ModelAndView mav = new ModelAndView();

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
    public ModelAndView showLogs() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("logs");

        mav.addObject("logs", calculatorService.findLogs().toString());
        return mav;
    }

    @RequestMapping(value = "/findByEredmeny", method = RequestMethod.GET)
    public ModelAndView findByEredmeny(@RequestParam("eredmeny") double eredmeny) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("logs");

        mav.addObject("logs", calculatorService.findByEredmeny(eredmeny));
        return mav;
    }

    @RequestMapping(value = "/findByOperator", method = RequestMethod.GET)
    public ModelAndView findByOperator(@RequestParam("operator") String operator) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("logs");

        mav.addObject("logs", calculatorService.findByOperator(operator));
        return mav;
    }

}
