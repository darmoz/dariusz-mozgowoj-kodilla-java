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

    public SummaryView()  {
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
        String message = "Dear " + bookingEntry.getCustomer().getFirstName() + ",\n"
                + "Your request will be processed soon.\n\nBelow your final booking information: "
                + "\nBooking from: " + bookingEntry.getBookFrom()
                + "\nTo: " + bookingEntry.getBookTo()
                + "\nEmail: " + bookingEntry.getCustomer().getEmail()
                + "\n\nIf you have questions contact us: "
                + "\nCompany Phone: +48 999999"
                + "\nCompany Email: comppany@company.pl"
                + "\n\nWe will contact you soon with more details related to your request.";
        TextArea confirmationInfo = new TextArea("Please review your order information (below):", message);
        confirmationInfo.setWordWrap(true);
        confirmationInfo.setWidth("550");
        confirmationInfo.setHeight("300");
        addComponent(confirmationInfo);

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {bookingList = BookingList.getInstance();
    }

}
