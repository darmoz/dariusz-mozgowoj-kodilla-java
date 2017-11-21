package com.kodilla.spring.vaadin.example1;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.View;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
@Theme("valo")
public class CustomerUI extends UI {

    private VerticalLayout layout;
    private HorizontalLayout horizontalLayout;
    private TextField firstName;
    private TextField lastName;
    private TextField email;
    private TextField phoneNumber;
    private DateField bookFrom;
    private DateField bookTo;
    private Button sendRequest;

    @Autowired
    private BookingList bookingList;
    private BookingOrders bookingOrders;
    private  Customer customer;

    @Override
    protected void init(VaadinRequest request) {
        setupLayout();
        addHeader();
        addCustomer();
        addBookingDate();
        addRequestButton();
        requestButtonActions();
    }

    private void setupLayout() {
        layout = new VerticalLayout();
        layout.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(layout);
    }

    private void addHeader() {
        Label header = new Label("BOOKING FORM");
        header.addStyleName(ValoTheme.LABEL_H1);
        layout.addComponent(header);
    }

    public final void addCustomer() {
        firstName = new TextField("First Name");
        lastName = new TextField("Last Name");
        email = new TextField("E-mail");
        phoneNumber = new TextField("Phone number");
        layout.addComponents(firstName, lastName, email, phoneNumber);
    }

    public final void addBookingDate() {
        horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(true);
        bookFrom = new DateField("From:");
        bookTo = new DateField("To:");
        horizontalLayout.addComponents(bookFrom, bookTo);
        layout.addComponent(horizontalLayout);
    }

    public final void addRequestButton() {
        sendRequest = new Button("Send Request");
        layout.addComponent(sendRequest);
        sendRequest.addStyleName(ValoTheme.BUTTON_PRIMARY);
    }

    public final void requestButtonActions() {
        sendRequest.addClickListener(click -> {
            customer = new Customer(firstName.getValue(),lastName.getValue(),email.getValue(),
                    phoneNumber.getValue());
            if(customer.getFirstName().isEmpty())
                {
                    Notification.show("What is your name?");
                } else {
                        if(customer.getEmail().isEmpty() && customer.getPhoneNumber().isEmpty())
                            {
                                Notification.show("Please provide valid communication method");
                            } else {

                                    bookingList = BookingList.getInstance();
                                    bookingOrders = new BookingOrders(customer, bookFrom.getValue(),
                                    bookTo.getValue());
                                    if(bookingOrders.getBookFrom() == null || bookingOrders.getBookTo() == null
                                            || bookingOrders.getBookFrom().isAfter(bookingOrders.getBookTo())) {
                                        Notification.show("Please provide valid dates");
                                    } else {
                                        bookingList.addEntry(bookingOrders);
                                        bookFrom.clear();
                                        bookTo.clear();
                                        firstName.clear();
                                        lastName.clear();
                                        email.clear();
                                        phoneNumber.clear();
                                        Notification.show("Request has been sent!");

                                    }
                            }
                        }
        });

    }
}