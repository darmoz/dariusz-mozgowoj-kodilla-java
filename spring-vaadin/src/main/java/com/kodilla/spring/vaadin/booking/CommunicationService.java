package com.kodilla.spring.vaadin.booking;


import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface CommunicationService {
    void sendMessage() throws MessagingException;
}
