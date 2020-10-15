package com.codegym.service;

import org.springframework.stereotype.Service;

@Service
public class CaculateImp implements Caculate {

    @Override
    public double caculate(double num1, double num2, String operator) {
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
            case "div":
                if(num2 == 0){
                    result =  0;
                }
                result =  num1 / num2;
                break;
            default:
                result =  0;
        }
        return result;
    }
}
