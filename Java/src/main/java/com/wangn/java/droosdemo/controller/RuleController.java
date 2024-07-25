package com.wangn.java.droosdemo.controller;


import com.wangn.java.droosdemo.entity.Calculation;
import com.wangn.java.droosdemo.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/rule")
public class RuleController {

    @Resource
    private RuleService ruleService;

    @RequestMapping("/calculate")
    public Calculation calculate(double wage) {
        try {
            Calculation calculation = new Calculation();
            calculation.setWage(wage);
            calculation = ruleService.calculate(calculation);
            System.out.println(calculation);
            return calculation;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}