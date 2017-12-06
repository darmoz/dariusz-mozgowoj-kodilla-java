package com.kodilla.spring.vaadin.booking;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "CUSTOMERS")
public class Customer {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private BookingOrders bookingOrders;

    public Customer() {}

    public Customer(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "CUSTOMER_ID", unique = true)
    public int getId() { return id;}

    @NotNull
    @Column(name = "FIRST_NAME")
    public String getFirstName() {
        return firstName;
    }

    @NotNull
    @Column(name = "LAST_NAME")
    public String getLastName() {
        return lastName;
    }

    @NotNull
    @Column(name = "EMAIL")
    public String getEmail() {
        return email;
    }

    @NotNull
    @Column(name = "PHONE_NUMBER")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "BOOKING_ORDERS_ID")
    public BookingOrders getBookingOrders() {
        return bookingOrders;
    }

    public void setId(int id) { this.id = id; }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBookingOrders(BookingOrders bookingOrders) {
        this.bookingOrders = bookingOrders;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
