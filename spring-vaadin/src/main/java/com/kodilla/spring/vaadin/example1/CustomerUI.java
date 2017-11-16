package com.kodilla.spring.vaadin.example1;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;


@SpringUI
@Theme("valo")
public class CustomerUI extends UI {

    private VerticalLayout layout;

    @Autowired
    BookingList bookingList;

    @Override
    protected void init(VaadinRequest request) {
        setupLayout();
        addHeader();
        addForm();
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

    public final void addForm() {
        TextField firstName = new TextField("First Name");
        TextField lastName = new TextField("Last Name");
        TextField email = new TextField("E-mail");
        TextField phoneNumber = new TextField("Phone number");
        layout.addComponents(firstName, lastName, email, phoneNumber);
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.setSpacing(true);
        //horizontalLayout.setWidth("35%");
        //for this case default value of above (commented) is fine
        DateField bookFrom = new DateField("From:");
        DateField bookTo = new DateField("To:");
        horizontalLayout.addComponents(bookFrom, bookTo);
        layout.addComponent(horizontalLayout);
        Button sendRequest = new Button("Send Request");
        layout.addComponent(sendRequest);
        sendRequest.addStyleName(ValoTheme.BUTTON_PRIMARY);

        sendRequest.addClickListener(click -> {
            bookingList.addEntry(
            new BookingOrders(new Customer(firstName.getValue(),lastName.getValue(),email.getValue(),
                    phoneNumber.getValue()), bookFrom.getValue(), bookTo.getValue()));
        bookFrom.clear();
        bookTo.clear();
        firstName.clear();
        lastName.clear();
        email.clear();
        phoneNumber.clear();
        });
        sendRequest.addClickListener(click -> {Notification.show("Request has been sent!");});
        System.out.println(bookingList.getEntry(0));
    }
}