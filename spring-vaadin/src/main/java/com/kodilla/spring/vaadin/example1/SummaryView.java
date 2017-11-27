package com.kodilla.spring.vaadin.example1;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import java.util.List;


@SpringView
public class SummaryView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "summary";
    private BookingList bookingList;
    private List list;

    public SummaryView() {
        bookingList = BookingList.getInstance();
        list = bookingList.getList();
        String bookingRequest = list.get(0).toString();
        Label messageAfterRequest = new Label("Dear " + bookingRequest );
        addComponent(messageAfterRequest);
        System.out.println(list.size());

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        list = BookingList.getInstance().getList();
    }

}
