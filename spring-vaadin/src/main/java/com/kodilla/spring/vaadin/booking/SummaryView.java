package com.kodilla.spring.vaadin.booking;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


@SpringView
public class SummaryView extends VerticalLayout implements View {
    public static final String VIEW_NAME = "summary";
    private BookingList bookingList;
    private BookingOrders bookingEntry;

    public SummaryView() throws SQLException {
        /*DbManager dbManager = DbManager.getInstance();

        String sqlQuery = "SELECT * FROM CUSTOMERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);
        Label messageAfterRequest = new Label("Dear " +
                rs.getString("FIRST_NAME") + ", " +
                rs.getString("LAST_NAME"));
        messageAfterRequest.setWidth("400");
        addComponent(messageAfterRequest);
        rs.close();
        statement.close();*/


        bookingList = BookingList.getInstance();
        bookingEntry = bookingList.getEntry(0);
        Label messageAfterRequest = new Label("Dear " + bookingEntry.getCustomer().getFirstName() + ","
         + " Your request will be processed soon. Below your final booking information " + "Booking from: "
         + bookingEntry.getBookFrom() + " to: " + bookingEntry.getBookTo());
        messageAfterRequest.setWidth("400");
        addComponent(messageAfterRequest);

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {bookingList = BookingList.getInstance();
    }

}
