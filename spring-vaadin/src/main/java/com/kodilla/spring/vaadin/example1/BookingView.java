package com.kodilla.spring.vaadin.example1;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;

import java.time.LocalDate;

@Theme("valo")
@SpringView
public class BookingView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "";

    private TextField firstName;
    private TextField lastName;
    private TextField email;
    private TextField phoneNumber;
    private HorizontalLayout horizontalLayout;
    private DateField bookFrom;
    private DateField bookTo;
    private BookingList bookingList;
    private BookingOrders bookingOrders;
    private Customer customer;
    private Button sendRequest;
    private EmailCommunication emailCommunication;

    public BookingView() {
        Label header = new Label("BOOKING FORM");
        header.addStyleName(ValoTheme.LABEL_H1);
        firstName = new TextField("First Name: ");
        lastName = new TextField("Last Name: ");
        email = new TextField("Email: ");
        phoneNumber = new TextField("Phone No.: ");
        horizontalLayout = new HorizontalLayout();
        bookFrom = new DateField("From: ");
        bookTo = new DateField("To: ");
        horizontalLayout.addComponents(bookFrom, bookTo);
        addComponents(header, firstName, lastName, email, phoneNumber, horizontalLayout);
        addRequestButton();
    }

    public void addRequestButton() {
        sendRequest = new Button("Send Request");
        sendRequest.addStyleName(ValoTheme.BUTTON_PRIMARY);
        sendRequest.addClickListener(e -> sendRequestExecution());
        addComponent(sendRequest);
    }

    private final void sendRequestExecution() {
        if(fieldsValidator()) {
            bookingList = BookingList.getInstance();
            customer = new Customer(firstName.getValue(),lastName.getValue(),email.getValue(),
                    phoneNumber.getValue());
            bookingOrders = new BookingOrders(customer, bookFrom.getValue(), bookTo.getValue());
            bookingList.addEntry(bookingOrders);
            UI ui = UI.getCurrent();
            Navigator navigator = ui.getNavigator();
            navigator.navigateTo(SummaryView.VIEW_NAME);
            Notification.show("Request has been sent!");
            //emailCommunication.sendMessage("dariusz.mozgowoj@gmail.com", "dariusz.mozgowoj@gmail.com", "none", "example");
            System.out.println(bookingList.getEntry(0).getCustomer().getFirstName());
        }
    }

    private boolean fieldsValidator() {
        boolean isValid = false;
            if(firstName.getValue().isEmpty() || lastName.getValue().isEmpty()) {
                    Notification.show("Provide both, first and last name");
                } else {
                        if(email.getValue().isEmpty() && phoneNumber.getValue().isEmpty()) {
                                Notification.show("Please provide valid communication method");
                            } else {
                                    if(bookFrom.getValue() == null || bookTo.getValue() == null
                                            || bookFrom.getValue().isAfter(bookTo.getValue())
                                            || bookFrom.getValue().isBefore(LocalDate.now())) {
                                            Notification.show("Please provide valid dates");
                                            isValid = false;
                                    } else isValid = true;
                            }
                        }
             return isValid;
            }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        bookFrom.clear();
        bookTo.clear();
        firstName.clear();
        lastName.clear();
        email.clear();
        phoneNumber.clear();
    }
}