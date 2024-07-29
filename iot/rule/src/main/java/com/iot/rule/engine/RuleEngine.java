package com.iot.rule.engine;


import com.iot.rule.entity.Device;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.utils.KieHelper;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
public class RuleEngine {


    public  RuleEngine (String ruleFilePath,Device device) throws Exception {
        KieSession session = createKieSessionFromDRL(ruleFilePath);
        session.insert(device);
        session.fireAllRules();
        session.dispose();
    }


    public KieSession createKieSessionFromDRL(String drlFullPath) throws Exception{
        //设置规则所使用的日期格式
        System.setProperty("drools.dateformat", "yyyy-MM-dd");
        //读取规则文件中的内容，实际项目中，可以把规则内容存储到数据库中，或者 web 服务器上，或者 oss 中
        //当前把规则就存放在文件中，在项目运行中，在不重启项目的情况下，可以修改规则内容并立刻生效
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream(drlFullPath), StandardCharsets.UTF_8))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
        }

        KieHelper kieHelper = new KieHelper();
        kieHelper.addContent(sb.toString(), ResourceType.DRL);
        return kieHelper.build().newKieSession();
    }
}