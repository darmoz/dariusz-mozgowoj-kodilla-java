package com.kodilla.spring.example;

import org.springframework.stereotype.Component;

@Component
public class GlobalIpServices implements IpServices {
    @Override
    public String getIp() {
        return "IP Address";
    }
}
