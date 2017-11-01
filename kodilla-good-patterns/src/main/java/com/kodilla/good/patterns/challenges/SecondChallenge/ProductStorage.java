package com.kodilla.good.patterns.challenges.SecondChallenge;

import java.util.HashMap;
import java.util.Map;

public class ProductStorage {
    Map<String, Integer> shopStorage = new HashMap<>();

    public Map<String, Integer> createStorage() {
        shopStorage.put("Game", 5);
        shopStorage.put("Toothpaste", 20);
        shopStorage.put("Mobile", 1);
        return shopStorage;
    }


}
