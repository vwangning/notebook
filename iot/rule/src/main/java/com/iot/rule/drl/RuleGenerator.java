package com.iot.rule.drl;


import com.iot.rule.decision.Decision;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RuleGenerator {


    public static void generateRuleFile(Decision decision) throws IOException {
        // 读取模板文件
        String template = IOUtils.toString(
                RuleGenerator.class.getResourceAsStream("/decision-template.drl.peb"),
                StandardCharsets.UTF_8
        );

        // 用实际值替换占位符
        Map<String, String> replacements = new HashMap<>();
        replacements.put("deviceId", decision.getDeviceId());
        replacements.put("ruleCondition", decision.getRuleCondition());
        replacements.put("ruleValue", decision.getRuleValue());

        for (Map.Entry<String, String> entry : replacements.entrySet()) {
            template = template.replace("{{" + entry.getKey() + "}}", entry.getValue());
        }

        // 生成唯一的文件名
        String uniqueFileName = decision.getDeviceId() + "-" + UUID.randomUUID().toString() + ".drl";

        // 确定目标文件夹位置
        String targetDirPath = "/Users/wangning/IdeaProjects/notebook/iot/rule/src/main/resources/rule";
        File targetDir = new File(targetDirPath);

        // 如果目标文件夹不存在，则创建它
        if (!targetDir.exists()) {
            targetDir.mkdirs();
        }

        // 确定文件的完整路径
        String filePath = targetDirPath + "/" + uniqueFileName;

        // 将结果写入文件
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            IOUtils.write(template, fos, StandardCharsets.UTF_8);
        }

        System.out.println("Rule file generated: " + filePath);
    }
}