package com.kodilla.spring.vaadin.booking;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

import java.sql.SQLException;

@SpringUI
public class BookingUI extends UI {
    @Override
    protected void init(VaadinRequest request) {
        Navigator navigator = new Navigator(this, this);

        navigator.addView(BookingView.VIEW_NAME, new BookingView());

        navigator.addView(SummaryView.VIEW_NAME, SummaryView.class);

        navigator.addView(ConfirmationEmailView.VIEW_NAME, ConfirmationEmailView.class);

        navigator.navigateTo(BookingView.VIEW_NAME);
    }

}
