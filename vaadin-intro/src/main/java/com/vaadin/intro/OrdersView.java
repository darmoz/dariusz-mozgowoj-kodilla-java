package com.vaadin.intro;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SpringView
public class OrdersView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "orders";

    public OrdersView() {
        Label lblOrders = new Label("New orders: ");
        addComponent(lblOrders);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // for example: load / reload data from database
    }
}
