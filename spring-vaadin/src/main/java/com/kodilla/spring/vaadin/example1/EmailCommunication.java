package com.kodilla.spring.vaadin.example1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public final class EmailCommunication implements CommunicationService {
    private Customer customer;
    private MailSender mailSender;
    private SimpleMailMessage simpleMailMessage;

    public void setMailSender(MailSender mailSender) {
        this.mailSender=mailSender;
    }

    public void sendMessage() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(customer.getEmail());
        simpleMailMessage.setFrom("dariusz.mozgowoj@gmail.com");
        simpleMailMessage.setText("Dear " + customer.getFirstName() + ",\n Thank you for choosing us.\n"
                + "We will contact you soon with more details about your request");
        try {
            this.mailSender.send(simpleMailMessage);
        } catch(MailException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
