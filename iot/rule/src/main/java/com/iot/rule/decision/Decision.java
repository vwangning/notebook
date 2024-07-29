package com.iot.rule.decision;


import lombok.Data;

@Data
public class Decision {

    // 这个对象的值由前端给
    private String   deviceId;

    // 规则条件 比如 > ,<,== 等只能取一个
    private String ruleCondition;

    //规则值 具体的值
    private String ruleValue;


}