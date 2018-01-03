package com.kodilla.spring.vaadin.booking.views;

import com.kodilla.spring.vaadin.booking.dbService.BookingList;
import com.kodilla.spring.vaadin.booking.BookingOrders;
import com.kodilla.spring.vaadin.booking.emailService.MailCommunication;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Page;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

import javax.mail.MessagingException;
import java.io.IOException;

@SpringView
public class SummaryView extends VerticalLayout implements View{
    public static final String VIEW_NAME = "summary";
    private BookingList bookingList;
    private BookingOrders bookingEntry;
    private Button confirm;
    private Button cancel;
    private HorizontalLayout horizontalLayout;
    private String message;


    @Autowired
    private MailCommunication mailCommunication;

    public SummaryView() {
        orderInfo();
        addDecisionButtons();
    }


    public void orderInfo() {
        bookingList = BookingList.getInstance();
        bookingEntry = bookingList.getEntry(0);
        message = "Dear " + bookingEntry.getCustomer().getFirstName() + ",\n"
                + "Your request will be processed soon.\n\nYour final booking information: "
                + "\nBooking from: " + bookingEntry.getBookFrom()
                + "\nTo: " + bookingEntry.getBookTo()
                + "\nEmail: " + bookingEntry.getCustomer().getEmail()
                + "\n\nIf you have questions contact us: "
                + "\nCompany Phone: +48 999999"
                + "\nCompany Email: company@company.pl"
                + "\n\nWe will contact you soon with more details related to your request.";
        TextArea confirmationInfo = new TextArea("Please review your order information (below):", message);
        confirmationInfo.setWordWrap(true);
        confirmationInfo.setWidth("550");
        confirmationInfo.setHeight("300");
        confirmationInfo.setReadOnly(true);
        addComponent(confirmationInfo);
    }

    public void addDecisionButtons() {
        horizontalLayout = new HorizontalLayout();
        confirm = new Button("Confirm", f -> {
            try {
                sendEmail(bookingEntry.getCustomer().getEmail());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        });
        confirm.addStyleName(ValoTheme.BUTTON_PRIMARY);
        cancel = new Button("Cancel");
        cancel.addStyleName(ValoTheme.BUTTON_PRIMARY);
        cancel.addClickListener(e -> cancelButtonExecution());
        horizontalLayout.addComponents(confirm, cancel);
        addComponent(horizontalLayout);
    }

    public final void cancelButtonExecution() {
        UI ui = UI.getCurrent();
        Navigator navigator = ui.getNavigator();
        navigator.navigateTo(BookingView.VIEW_NAME);
    }

    public void sendEmail(String to) throws IOException, MessagingException {
        String from = "noreply@company.com";
        String subject = "Confirmation Email";
        String body = message;

        mailCommunication.sendMessage(from, to, subject, body);
        Notification confirmNotification = new Notification(
                "INFORMATION",
                "Email has been sent!",
                Notification.Type.HUMANIZED_MESSAGE);

        confirmNotification.setDelayMsec(1000);
        confirmNotification.show(Page.getCurrent());

        UI ui = UI.getCurrent();
        Navigator navigator = ui.getNavigator();
        navigator.navigateTo(BookingView.VIEW_NAME);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        bookingList = BookingList.getInstance();
    }
}

