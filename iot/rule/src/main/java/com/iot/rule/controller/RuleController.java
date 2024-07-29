package com.iot.rule.controller;



import com.iot.rule.controller.param.DecisionParam;
import com.iot.rule.decision.Decision;
import com.iot.rule.drl.RuleGenerator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class RuleController {


    @PostMapping("/rule/add")
    public String addRule(@RequestBody DecisionParam decisionParam ) throws IOException {
        Decision decision = new Decision();
        decision.setDeviceId(decisionParam.getDeviceId());
        decision.setRuleCondition(decisionParam.getRuleCondition());
        decision.setRuleValue(decisionParam.getRuleValue());
        RuleGenerator.generateRuleFile(decision);
        return "success";
    }
}