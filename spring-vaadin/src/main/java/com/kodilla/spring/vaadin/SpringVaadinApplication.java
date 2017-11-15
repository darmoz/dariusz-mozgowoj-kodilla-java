package com.kodilla.spring.vaadin;

import com.kodilla.spring.vaadin.example1.BookingList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringVaadinApplication {

	public static void main(String[] args) {
		BookingList bookingList = new BookingList();
		SpringApplication.run(SpringVaadinApplication.class, args);
		System.out.println(bookingList.getEntry(0));
	}
}
