package com.iot.rule.entity;


import lombok.Data;

@Data
public class Device {

    private String deviceId;

    private String temperature;

    private String action;
}