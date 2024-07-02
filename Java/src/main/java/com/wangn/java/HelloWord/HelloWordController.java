package com.wangn.java.HelloWord;




import com.wangn.java.redis.ReidsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {



    @Autowired
    private ReidsUtil redisUtil;
    @RequestMapping("/index")
    @ResponseBody
    public String index(){

        redisUtil.set("mykey","world!");
        String o = (String) redisUtil.get("mykey");
        System.out.println(o);

//        commonCacheOperator.put("mykey","world!");
//        System.out.println(commonCacheOperator.get("mykey"));
        return "hello world!";

    }
}