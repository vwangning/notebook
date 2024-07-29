package com.iot.mqtt.entity;


import lombok.Data;

@Data
public class Device {

    private String deviceId;

    private Double temperature;
}