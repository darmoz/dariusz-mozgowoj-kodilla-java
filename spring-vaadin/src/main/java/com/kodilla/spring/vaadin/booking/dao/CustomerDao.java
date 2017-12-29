package com.kodilla.spring.vaadin.booking.dao;

import com.kodilla.spring.vaadin.booking.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface CustomerDao extends CrudRepository<Customer, Integer> {

    @Override
    Customer save(Customer customer);
}
