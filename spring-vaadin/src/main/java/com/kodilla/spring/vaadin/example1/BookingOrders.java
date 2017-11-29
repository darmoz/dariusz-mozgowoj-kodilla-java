package com.kodilla.spring.vaadin.example1;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

public class BookingOrders {

    private Customer customer;
    private LocalDate bookFrom;
    private LocalDate bookTo;

    public BookingOrders(Customer customer, LocalDate bookFrom, LocalDate bookTo) {
        this.customer = customer;
        this.bookFrom = bookFrom;
        this.bookTo = bookTo;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getBookFrom() {
        return bookFrom;
    }

    public LocalDate getBookTo() {
        return bookTo;
    }

    @Override
    public String toString() {
        return "BookingOrders{" +
                "customer=" + customer +
                ", bookFrom=" + bookFrom +
                ", bookTo=" + bookTo +
                '}';
    }
}
