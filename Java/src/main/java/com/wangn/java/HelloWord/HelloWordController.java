package com.wangn.java.HelloWord;




import com.wangn.java.LongLinkConversion.MD5Utils;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloWordController {



    @GetMapping("/index")

    public String index(ArrayList array){

       // System.out.println(array);
        return "hello world!";

    }

    @ResponseBody
    @PostMapping(value = "/mock/call")
    public  Map<String, Object> call(@RequestBody Map<String, Object> requestBody) throws NoSuchAlgorithmException {

        // 模拟返回结果
        Map<String, Object> response = new HashMap<>();
        // 打印请求参数
        System.out.println("Received request: " + requestBody);

        response.put("code", 0);
        Map<String, Object> data = new HashMap<>();
        data.put("xm", "张三");
        data.put("uid", MD5Utils.MD532("130726199705290039"));
        data.put("jh", "000001");
        data.put("imsis", "0000001");
        data.put("jwtdh", "13812345678");
        data.put("zgdwbm", "000001");
        data.put("zgdwmc", "我是单位");
        data.put("zgbmbm", "000001");
        data.put("zgbmmc", "我是部门");
        response.put("data", data);
        response.put("message", "message");
        response.put("success", true);

        return response;
    }

    @PostMapping(value = "/SKF_OpenApplication")
    public  Map<String, Object> openApplication(@RequestBody  OpenApplicationParam openApplicationParam){
        // 模拟返回结果
        Map<String, Object> response = new HashMap<>();
        return response;
    }
}