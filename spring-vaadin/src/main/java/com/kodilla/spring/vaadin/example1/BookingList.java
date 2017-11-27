package com.kodilla.spring.vaadin.example1;
import java.util.ArrayList;
import java.util.List;

public class BookingList {
    private static BookingList bookingListInstance = null;
    List<BookingOrders> orderList = new ArrayList<>();

    public static BookingList getInstance() {
        if(bookingListInstance==null) {
            bookingListInstance = new BookingList();
        }
        return bookingListInstance;
    }

    public List getList() {
        return orderList;
    }


    public void addEntry(BookingOrders bookingOrders) {
        orderList.add(bookingOrders);

    }
}
