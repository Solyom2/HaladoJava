package hu.me.webcalculator.service.impl;

import hu.me.webcalculator.model.Input;
import hu.me.webcalculator.model.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.ArrayList;

@Component
public class InputValidator implements Validator {

    private CalculatorService calculatorService;

    @Autowired
    public void setCalculatorService(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Input.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors err) {
        ValidationUtils.rejectIfEmpty(err, "a", "A ures");
        ValidationUtils.rejectIfEmpty(err, "b", "B ures");
        ValidationUtils.rejectIfEmpty(err, "operator", "Operator ures");

        Input input = (Input) obj;

        ArrayList<Log> logs = calculatorService.getLogs();
        for(Log log : logs) {
            if(input.getA() == log.getInput().getA() && input.getB() == log.getInput().getB() && input.getOperator().equals(log.getInput().getOperator())) {
                err.reject("Ezt a kalkulaciot mar elvegezte");
            }
        }
    }

}
