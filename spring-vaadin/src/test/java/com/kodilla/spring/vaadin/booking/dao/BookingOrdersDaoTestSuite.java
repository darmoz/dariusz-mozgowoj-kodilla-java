package com.kodilla.spring.vaadin.booking.dao;

import com.kodilla.spring.vaadin.booking.BookingOrders;
import com.kodilla.spring.vaadin.booking.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingOrdersDaoTestSuite {

    @Autowired
    BookingOrdersDao bookingOrdersDao;

    @Test
    public void testBookingOrersSave() {
        //Given
        Customer customer = new Customer("Dariusz", "Mozgowoj", "dariusz@wp.pl", "+481234567");
        BookingOrders order = new BookingOrders(null, LocalDate.of(2017, 12, 15),
                LocalDate.of(20117, 12, 25));
        bookingOrdersDao.save(order);
        int id = order.getId();
    }
}
