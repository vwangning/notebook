package com.iot.mqtt;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan(basePackages = {"com.iot.mqtt", "com.iot.rule"})
@SpringBootApplication
public class MQTTApplication {
    public static void main(String[] args)
    {
        SpringApplication.run(MQTTApplication.class, args);
    }
}