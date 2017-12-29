package com.kodilla.spring.vaadin.booking.dao;

import com.kodilla.spring.vaadin.booking.BookingOrders;
import com.kodilla.spring.vaadin.booking.Customer;
import com.kodilla.spring.vaadin.booking.dbService.DbManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BookingDaoTestSuite {

    @Autowired
    CustomerDao customerDao;

    @Autowired
    BookingOrdersDao bookingOrdersDao;

    @Test
    public void testCustomerDaoSave() {
        //Given
        Customer customer = new Customer("Dariusz", "Mozgowoj", "dariusz@wp.pl", "+481234567");
        BookingOrders order = new BookingOrders(customer, LocalDate.of(2017, 12, 15),
                LocalDate.of(2017, 12, 25));
        customer.setBookingOrders(order);
        //When
        customerDao.save(customer);
        int id = customer.getId();
        //Then
        Assert.assertEquals(1, id);
        //Clean up
        customerDao.delete(id);
    }

    @Test
    public void testBookingOrdersDaoSave() {
        //Given
        Customer customer = new Customer("Dariusz", "Mozgowoj", "dariusz@wp.pl", "+481234567");
        BookingOrders order = new BookingOrders(customer, LocalDate.of(2017, 12, 15),
                LocalDate.of(2017, 12, 25));
        order.setCustomer(customer);
        //When
        bookingOrdersDao.save(order);
        int id = order.getId();
        //Then
        Assert.assertEquals(5, id);
        //Clean up
        bookingOrdersDao.delete(id);

    }

    @Test
    public void testSelectCustomers() throws SQLException {
        //Given
        Customer customer = new Customer("Dariusz", "Mozgowoj", "dariusz@wp.pl", "+481234567");
        BookingOrders order = new BookingOrders(customer, LocalDate.of(2017, 12, 15),
                LocalDate.of(2017, 12, 25));
        customer.setBookingOrders(order);
        customerDao.save(customer);
        int id = customer.getId();
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT * FROM CUSTOMERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while(rs.next()) {
            System.out.println(rs.getInt("CUSTOMER_ID") + ", " +
                    rs.getString("FIRST_NAME") + ", " +
                    rs.getString("LAST_NAME"));
            counter++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(1, counter);
        //Clean up
        customerDao.delete(id);
    }
}
