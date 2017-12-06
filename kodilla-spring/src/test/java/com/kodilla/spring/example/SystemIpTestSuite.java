package com.kodilla.spring.example;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SystemIpTestSuite {

    @Test
    public void testTaskAdd() {
        //Given
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.kodilla.spring");
        SystemIp systemIp = context.getBean(SystemIp.class);
        //When
        systemIp.introMessage();
        systemIp.findIp();
    }
}
