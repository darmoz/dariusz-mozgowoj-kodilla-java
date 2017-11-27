package com.kodilla.spring.vaadin.example1;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;

@SpringUI
public class BookingUI extends UI {
    @Override
    protected void init(VaadinRequest request) {
        Navigator navigator = new Navigator(this, this);

        navigator.addView(BookingView.VIEW_NAME, new BookingView());
        navigator.addView(SummaryView.VIEW_NAME, SummaryView.class);

        navigator.navigateTo(BookingView.VIEW_NAME);
    }

}
