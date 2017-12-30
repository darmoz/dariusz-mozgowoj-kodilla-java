package com.kodilla.spring.vaadin.booking;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SpringView
public class ConfirmationEmailView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "email";

    public ConfirmationEmailView() {
        finalMessage();
    }

    public void finalMessage() {
        Label finalLabel = new Label("You confirm request successfully !");
        addComponent(finalLabel);
    }

}
