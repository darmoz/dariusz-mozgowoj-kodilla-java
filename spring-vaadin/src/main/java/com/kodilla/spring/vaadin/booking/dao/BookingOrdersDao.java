package com.kodilla.spring.vaadin.booking.dao;

import com.kodilla.spring.vaadin.booking.BookingOrders;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BookingOrdersDao extends CrudRepository<BookingOrders, Integer> {

    @Override
    BookingOrders save(BookingOrders bookingOrders);
}
