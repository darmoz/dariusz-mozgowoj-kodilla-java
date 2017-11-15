package com.kodilla.spring.vaadin.example1;

import java.time.LocalDate;

public class BookingOrders {

    Customer customer;
    LocalDate bookFrom;
    LocalDate bookTo;

    public BookingOrders(Customer customer, LocalDate bookFrom, LocalDate bookTo) {
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


}
