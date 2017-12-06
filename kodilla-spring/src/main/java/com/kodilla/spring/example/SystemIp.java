package com.kodilla.spring.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SystemIp {

    @Autowired
    IpServices ipServices;

    public void introMessage() {
        System.out.println("This is IP searcher");
    }

    public void findIp() {
        System.out.println(ipServices.getIp());
    }
}
