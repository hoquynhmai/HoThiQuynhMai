package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class CalculateImp implements Calculate {

    @Override
    public String calculate(double num1, double num2, String operator) {
        double result;
        switch (operator){
            case "add":
                result =  num1 + num2;
                break;
            case "subs":
                result =  num1 - num2;
                break;
            case "multi":
                result =  num1 * num2;
                break;
            default:
                if (num2 == 0) {
                    return "Cannot be divided by 0 !";
                } else {
                    result =  num1 / num2;
                }
        }
        return String.valueOf(result);
    }
}
