package com.kodilla.spring.vaadin.booking;


public interface CommunicationService {
    void sendMessage(String from, String to, String subject, String msg);
}
