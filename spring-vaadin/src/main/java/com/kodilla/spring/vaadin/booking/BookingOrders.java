package com.kodilla.spring.vaadin.booking;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "ORDERS")
public class BookingOrders {

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ORDER_ID", unique = true)
    private int id;

    @OneToOne(mappedBy = "bookingOrders", cascade = CascadeType.ALL)
    private Customer customer;

    @NotNull
    @Column(name = "DATE_FROM", columnDefinition = "varchar(20)")
    private LocalDate bookFrom;

    @NotNull
    @Column(name = "DATE_TO", columnDefinition = "varchar(20)")
    private LocalDate bookTo;

    public BookingOrders() {}

    public BookingOrders(Customer customer, LocalDate bookFrom, LocalDate bookTo) {
        this.customer = customer;
        this.bookFrom = bookFrom;
        this.bookTo = bookTo;
    }

    public int getId() { return id; }

    public Customer getCustomer() { return customer; }

    public LocalDate getBookFrom() {
        return bookFrom;
    }

    public LocalDate getBookTo() {
        return bookTo;
    }

    public void setId(int id) {
        this.id = id;
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
