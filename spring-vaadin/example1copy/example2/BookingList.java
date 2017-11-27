package com.kodilla.spring.vaadin.example2;

import com.vaadin.spring.annotation.SpringComponent;
import com.kodilla.spring.vaadin.example1.BookingOrders;

import java.util.ArrayList;
import java.util.List;

@SpringComponent
public class BookingList {
    private static BookingList bookingListInstance = null;
    List<BookingOrders> orderList = new ArrayList<>();;

    public static BookingList getInstance() {
        if(bookingListInstance==null) {
            bookingListInstance = new BookingList();
        }
        return bookingListInstance;
    }

    public List getEntry(int i) {
        orderList.get(i);
        return orderList;
    }

    public void addEntry(BookingOrders bookingOrders) {
        orderList.add(bookingOrders);

    }
}
