package com.kodilla.spring.vaadin.booking.dbService;

import com.kodilla.spring.vaadin.booking.BookingOrders;
import com.kodilla.spring.vaadin.booking.Customer;
import com.kodilla.spring.vaadin.booking.dao.BookingOrdersDao;
import com.kodilla.spring.vaadin.booking.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.util.resources.cldr.en.CalendarData_en_Dsrt_US;

@Service
public class DbService {

    @Autowired
    BookingOrdersDao bookingOrdersDao;

    @Autowired
    CustomerDao customerDao;

    public BookingOrders saveOrder(final BookingOrders bookingOrders) {
        return bookingOrdersDao.save(bookingOrders);
    }

    public Customer saveCustomer(final Customer customer) {
        return customerDao.save(customer);
    }
}
