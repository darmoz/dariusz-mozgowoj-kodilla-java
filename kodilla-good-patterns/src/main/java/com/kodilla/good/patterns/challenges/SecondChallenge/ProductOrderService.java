package com.kodilla.good.patterns.challenges.SecondChallenge;

import java.time.LocalDate;

public class ProductOrderService implements OrderService {

    public boolean order(User user, ProductType productType, LocalDate localDate) {
        System.out.println("Product type of " + productType.getType() + " has been ordered at " + localDate.toString()
                + " by " + user.getFirstName() + " " + user.getLastName());
        return true;

    }

}
