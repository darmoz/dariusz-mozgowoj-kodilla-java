package com.kodilla.good.patterns.challenges.SecondChallenge;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ProductOrderService implements OrderService {

    public boolean order(User user, ProductType productType, LocalDate localDate) {
        ProductStorage storage = new ProductStorage();
        if(storage.createStorage().containsKey(productType.getType())) {
            System.out.println("Product type of " + productType.getType() + " has been ordered at " + localDate.toString()
                    + " by " + user.getFirstName() + " " + user.getLastName());
            return true;
        } else {
            System.out.println("Product is not available!");
            return false;
        }

    }

}
