package com.kodilla.spring.vaadin.booking.controller;

import com.kodilla.spring.vaadin.booking.Customer;
import com.kodilla.spring.vaadin.booking.dbService.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Controller
public class CustomerController {

    @Autowired
    DbService dbService;

    @Transactional
    @RequestMapping(method = RequestMethod.POST, value = "createTask", consumes = APPLICATION_JSON_VALUE)
    public void createCustomerOrder(@RequestBody Customer customer) { dbService.saveCustomer(customer);}
}
