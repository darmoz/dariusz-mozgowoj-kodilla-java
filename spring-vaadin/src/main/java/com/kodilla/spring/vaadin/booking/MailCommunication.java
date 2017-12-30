package com.kodilla.spring.vaadin.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
@EnableAutoConfiguration
public final class MailCommunication implements CommunicationService {
    @Autowired
    private MailSender mailSender;

    private SimpleMailMessage templateMessage;

    public void setEmailSender(MailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void setTemplateMessage(SimpleMailMessage templateMessage) {
        this.templateMessage = templateMessage;
    }

    @Override
    public void sendMessage(final Mail mail) {
        SimpleMailMessage message = new SimpleMailMessage(this.templateMessage);
        message.setSubject(mail.getSubject());
        message.setText(mail.getContent());
        message.setTo(mail.getTo());
        message.setFrom(mail.getFrom());
        try {
            this.mailSender.send(message);
        }
        catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
