package com.kodilla.spring.vaadin.example1;


public interface CommunicationService {
    void sendMessage(String from, String to, String subject, String msg);
}
