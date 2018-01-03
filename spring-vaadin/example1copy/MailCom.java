package com.kodilla.spring.vaadin.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MailCom {

    @Autowired
    MailSender mailSender;

    private SimpleMailMessage templateMailMessage;

    @RequestMapping("/send.html")
    public String send() {
        System.out.println("Start sending...");
        String response = "OK";
        this.templateMailMessage = new SimpleMailMessage();

        this.templateMailMessage.setFrom("noreply@gmail.com");
        this.templateMailMessage.setTo("dariusz.mozgowoj@gmail.com");
        this.templateMailMessage.setSubject("Haloo!");

        SimpleMailMessage msg = new SimpleMailMessage(templateMailMessage);
        msg.setText("This is test email");

        this.mailSender.send(msg);
        return response;
    }
}
