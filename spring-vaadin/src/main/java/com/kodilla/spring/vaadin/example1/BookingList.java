package com.kodilla.spring.vaadin.example1;
import java.util.ArrayList;
import java.util.List;

public class BookingList {
    private static BookingList bookingListInstance = null;
    List<BookingOrders> orderList = new ArrayList<>();

    private BookingList() {
    }

    public static BookingList getInstance() {
        if(bookingListInstance==null) {
            bookingListInstance = new BookingList();
        }
        return bookingListInstance;
    }

   /* public List getList() {
        return orderList;
    }*/
    public BookingOrders getEntry(int i) {return orderList.get(i);}


    public void addEntry(BookingOrders bookingOrders) {
        orderList.add(bookingOrders);

    }
}
