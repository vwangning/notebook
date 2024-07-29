package com.iot.mqtt.handler;



import cn.hutool.json.JSONUtil;
import com.iot.rule.engine.RuleEngine;
import com.iot.rule.entity.Device;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Component
public class MqttMessageHandler {

    public void handleMessage(String payload) throws Exception {
        System.out.println("Received MQTT message: " + payload);
        // 在这里处理接收到的消息
        String ruleFilePath = "/Users/wangning/IdeaProjects/notebook/iot/rule/src/main/resources/rule/1-4e390ca1-7af4-440f-8c27-f8d23f81e060.drl"; // 替换为实际生成的文件路径
        Device device = JSONUtil.toBean(payload, Device.class);
        RuleEngine ruleEngine = new RuleEngine(ruleFilePath, device);

    }

}