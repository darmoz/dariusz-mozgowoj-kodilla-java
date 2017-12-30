package com.kodilla.spring.vaadin.booking;
import org.springframework.mail.MailException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

@Service
public final class MailCommunication implements CommunicationService {

    @Override
    @RequestMapping(path = "/email", method = RequestMethod.POST)
    public void sendMessage() throws MessagingException {
        String host = "smtp.gmail.com";
        String to = "dariusz.mozgowoj@gmail.com";
        String from = "noreply@gmail.com";
        Properties props = System.getProperties();
        props.put(host, host);
        Session session = Session.getDefaultInstance(props, null);
        MimeMessage msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(from));
        msg.addRecipient(javax.mail.Message.RecipientType.TO,
                new InternetAddress(to));
        msg.setSubject("Halloo");
        msg.setText("This is test mail");

        try {
            Transport.send(msg);
        }
        catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
