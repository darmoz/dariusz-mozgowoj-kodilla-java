package com.kodilla.good.patterns.challenges.SecondChallenge;

import java.time.LocalDate;

public class OrderRequest {

    private User user;
    private ProductType productType;
    private LocalDate transactionDate;


    public OrderRequest(User user, ProductType productType, LocalDate transactionDate) {
        this.user = user;
        this.productType = productType;
        this.transactionDate = transactionDate;
    }

    public User getUser() {
        return user;
    }

    public ProductType getProductType() {
        return productType;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }
}
