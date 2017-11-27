package com.vaadin.intro;

import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.UI;


@SpringUI
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        Navigator navigator = new Navigator(this, this);

        navigator.addView(WelcomeView.VIEW_NAME, new WelcomeView());
        navigator.addView(OrdersView.VIEW_NAME, OrdersView.class);

        navigator.navigateTo(WelcomeView.VIEW_NAME);

    }

}
