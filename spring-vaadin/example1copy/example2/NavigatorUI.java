package com.kodilla.spring.vaadin.example2;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;

@SpringUI
public class NavigatorUI extends UI {
    @Autowired
    Navigator navigator;
    protected static final String NAME = "main";

    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("Navigation Example");

        // Create a navigator to control the views
        navigator = new Navigator(this, this);

        // Create and register the views
        navigator.addView(NAME, new BookFormView());
        navigator.addView("", new SummaryView());
    }
}
