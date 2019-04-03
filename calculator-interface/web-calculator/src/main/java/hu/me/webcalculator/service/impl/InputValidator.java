package hu.me.webcalculator.service.impl;

import hu.me.webcalculator.model.Input;
import hu.me.webcalculator.model.Log;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.ArrayList;

@Component
public class InputValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Input.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors err) {
        ValidationUtils.rejectIfEmpty(err, "a", "input.a.empty");
        ValidationUtils.rejectIfEmpty(err, "b", "input.b.empty");
        ValidationUtils.rejectIfEmpty(err, "operator", "input.operator.empty");

        Input input = (Input) obj;

        if(input.getA() == 2) {
            System.out.println("fref");
        }

        /*ArrayList<Log> logs = calculatorService.getLogs();
        for(Log log : logs) {
            if(input.equals(log.getInput())) {
                err.reject("input");
            }
        }*/
    }

}
