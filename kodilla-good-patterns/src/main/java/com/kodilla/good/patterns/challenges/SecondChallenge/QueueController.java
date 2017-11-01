package com.kodilla.good.patterns.challenges.SecondChallenge;

import java.lang.reflect.Array;
import java.util.ArrayDeque;

public class QueueController {

    OrderRequestRetriever retriever = new OrderRequestRetriever();
    ArrayDeque<OrderRequest> queue = new ArrayDeque<>();

    public void addToQueue() {
        queue.offer(retriever.retrieve());
        System.out.println("Order has been added to the working queue!");
    }

    public void removeFromQueue() {
        OrderRequest temporaryOrder;
        temporaryOrder = queue.poll();
    }
}
