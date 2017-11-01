package com.kodilla.good.patterns.challenges.SecondChallenge;

import java.time.LocalDate;

public class Application {

    public static void main (String[] args) {

        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();
        OrderingProcessor orderingProcessor = new OrderingProcessor(new MailService(),new ProductOrderService(), new ProductRepositoryService());
        orderingProcessor.process(orderRequest);
    }
}
