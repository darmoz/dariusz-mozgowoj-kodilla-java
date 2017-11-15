package com.kodilla.spring.vaadin.example1;

import com.vaadin.spring.annotation.SpringComponent;

import java.util.ArrayList;
import java.util.List;

@SpringComponent
public class BookingList {

    List<BookingOrders> orderList;

    public BookingList() {
        orderList = new ArrayList<>();
    }

    public List getEntry(int i) {
        orderList.get(i);
        return orderList;
    }

    public void addEntry(BookingOrders bookingOrders) {
        orderList.add(bookingOrders);

    }
}
