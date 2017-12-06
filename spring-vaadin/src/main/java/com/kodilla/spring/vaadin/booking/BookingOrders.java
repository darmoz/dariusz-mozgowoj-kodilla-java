package com.kodilla.spring.vaadin.booking;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
@Entity
@Table(name = "ORDERS")
public class BookingOrders {

    private int id;
    private Customer customer;
    private LocalDate bookFrom;
    private LocalDate bookTo;

    public BookingOrders() {}

    public BookingOrders(Customer customer, LocalDate bookFrom, LocalDate bookTo) {
        this.customer = customer;
        this.bookFrom = bookFrom;
        this.bookTo = bookTo;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ORDER_ID", unique = true)
    public int getId() { return id; }


    public Customer getCustomer() {
        return customer;
    }

    @NotNull
    @Column(name = "DATE_FROM")
    public LocalDate getBookFrom() {
        return bookFrom;
    }

    @NotNull
    @Column(name = "DATE_TO")
    public LocalDate getBookTo() {
        return bookTo;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setBookFrom(LocalDate bookFrom) {
        this.bookFrom = bookFrom;
    }

    public void setBookTo(LocalDate bookTo) {
        this.bookTo = bookTo;
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
