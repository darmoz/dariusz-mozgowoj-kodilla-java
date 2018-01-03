package com.kodilla.spring.vaadin.booking.views;

import com.kodilla.spring.vaadin.booking.dbService.BookingList;
import com.kodilla.spring.vaadin.booking.BookingOrders;
import com.kodilla.spring.vaadin.booking.Customer;
import com.kodilla.spring.vaadin.booking.controller.CustomerController;
import com.kodilla.spring.vaadin.booking.dao.CustomerDao;
import com.vaadin.annotations.Theme;
import com.vaadin.data.Binder;
import com.vaadin.data.validator.DateRangeValidator;
import com.vaadin.data.validator.EmailValidator;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.Page;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@Theme("valo")
@SpringView
public class BookingView extends VerticalLayout implements View {

    public static final String VIEW_NAME = "";

    @Autowired
    CustomerDao customerDao;
    @Autowired
    CustomerController customerController;

    private TextField firstName;
    private TextField lastName;
    private TextField email;
    private TextField phoneNumber;
    private HorizontalLayout horizontalDates;
    private HorizontalLayout horizontalUser;
    private HorizontalLayout horizontalCommunication;
    private DateField bookFrom;
    private DateField bookTo;
    private BookingList bookingList;
    private BookingOrders bookingOrders;
    private Customer customer;
    private Button sendRequest;
    //private EmailCommunication emailCommunication;
    private Binder<Customer> userBinder;
    private Binder<BookingOrders> orderBinder;
    Binder.BindingBuilder<BookingOrders, LocalDate> dateBidingBuilder;

    public BookingView() {
        Label header = new Label("CREATE NEW BOOKING REQUEST");
        header.addStyleName(ValoTheme.LABEL_H2);
        addUserInfo();
        addCommunicationInfo();
        addBookingDate();
        addComponents(header, horizontalUser, horizontalCommunication, horizontalDates);
        addRequestButton();
    }

    public void addUserInfo() {
        userBinder = new Binder<>();
        horizontalUser = new HorizontalLayout();
        firstName = new TextField("First Name: ");
        firstName.setPlaceholder("John");
        firstName.setIcon(VaadinIcons.USER);
        userBinder.forField(firstName).asRequired("First Name can not be empty!")
                .withValidator(name -> name.length()>=3, "First name is too short!")
                .bind(Customer::getFirstName, Customer::setFirstName);
        lastName = new TextField("Last Name: ");
        lastName.setPlaceholder("Wick");
        userBinder.forField(lastName).asRequired("Last Name can not be empty!")
                .withValidator(name -> name.length()>=2, "Last name is too short!")
                .bind(Customer::getLastName, Customer::setLastName);
        horizontalUser.addComponents(firstName, lastName);
    }

    public void addCommunicationInfo() {
        horizontalCommunication = new HorizontalLayout();
        email = new TextField("Email: ");
        email.setPlaceholder("abc@example.com");
        email.setIcon(VaadinIcons.ENVELOPE);
        userBinder.forField(email).asRequired("Email can not be empty!")
                .withValidator(new EmailValidator("This is not correct email address"))
                .bind(Customer::getEmail, Customer::setEmail);
        phoneNumber = new TextField("Phone No.: ");
        phoneNumber.setPlaceholder("+99 123456");
        phoneNumber.setIcon(VaadinIcons.PHONE);
        userBinder.forField(phoneNumber).asRequired("Phone number can not be empty!")
                .withValidator(number -> number.length()<=12,"Too many digits")
                .withValidator(number -> number.contains("+"), "You have missed \"+\"")
                .bind(Customer::getFirstName, Customer::setFirstName);
        horizontalCommunication.addComponents(email, phoneNumber);
    }

    public void addBookingDate() {
        orderBinder = new Binder<>();
        horizontalDates = new HorizontalLayout();
        bookFrom = new DateField("From: ");
        bookFrom.setIcon(VaadinIcons.CALENDAR);
        bookFrom.setPlaceholder("dd.mm.yy");
        orderBinder.forField(bookFrom).asRequired("Date from can not be empty!")
                .withValidator(new DateRangeValidator("Date is out of available range",
                 LocalDate.now(), LocalDate.of(2018, 12, 30)))
                .bind(BookingOrders::getBookFrom, BookingOrders::setBookFrom);
        bookTo = new DateField("To: ");
        bookTo.setPlaceholder("dd.mm.yy");
        orderBinder.forField(bookTo).asRequired("Date to can not be empty!")
                .withValidator(new DateRangeValidator("Date is out of available range",
                LocalDate.now(), LocalDate.of(2018, 12, 30)))
                .withValidator(bookToDate -> !bookToDate.isBefore(bookFrom.getValue()),
                        "Last date should be after first date")
                .bind(BookingOrders::getBookTo, BookingOrders::setBookTo);
        horizontalDates.addComponents(bookFrom, bookTo);
    }

    public void addRequestButton() {
        sendRequest = new Button("Create request");
        sendRequest.focus();
        sendRequest.addStyleName(ValoTheme.BUTTON_PRIMARY);
        sendRequest.addClickListener(e -> sendRequestExecution());
        addComponent(sendRequest);
    }

    private final void sendRequestExecution() {
        if (userBinder.isValid() && orderBinder.isValid()) {
            bookingList = BookingList.getInstance();
            customer = new Customer(firstName.getValue(), lastName.getValue(), email.getValue(),
                    phoneNumber.getValue());
            bookingOrders = new BookingOrders(customer, bookFrom.getValue(), bookTo.getValue());
            customer.setBookingOrders(bookingOrders);
            //customerController.createCustomerOrder(customer);
            bookingList.addEntry(bookingOrders);
            UI ui = UI.getCurrent();
            Navigator navigator = ui.getNavigator();
            navigator.navigateTo(SummaryView.VIEW_NAME);
        } else {
            Notification warningNotification = new Notification(
                "WARNING",
                    "Request could not be saved. Please fill all fields",
                    Notification.Type.WARNING_MESSAGE);

            warningNotification.setDelayMsec(700);
            warningNotification.show(Page.getCurrent());
        }
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        bookFrom.clear();
        bookTo.clear();
        firstName.clear();
        lastName.clear();
        email.clear();
        phoneNumber.clear();
    }
}