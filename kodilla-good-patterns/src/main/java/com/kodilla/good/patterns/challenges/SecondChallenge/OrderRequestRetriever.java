package com.kodilla.good.patterns.challenges.SecondChallenge;

import java.time.LocalDate;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {

        User user = new User("Dariusz", "Mozgowoj");

        ProductType productType = new ProductType("Game");

        LocalDate transactionDate = LocalDate.now();

        OrderRequest order = new OrderRequest(user, productType, transactionDate);
        return order;
    }
}
