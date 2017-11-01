package com.kodilla.good.patterns.challenges.SecondChallenge;

import java.time.LocalDate;

public interface OrderService {

    boolean order(User user, ProductType productType, LocalDate localDate);
}
