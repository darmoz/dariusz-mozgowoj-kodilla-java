package com.kodilla.testing.collection;

import java.util.*;

public class OddNumbersExterminator {
    ArrayList<Integer> even = new ArrayList<>();

    public ArrayList exterminator(ArrayList<Integer> numbers) {

        if (numbers.size() != 0) {
            for (int i = 0; i < numbers.size(); i++) {
                if (numbers.get(i) % 2 == 0) {
                    System.out.println(numbers.get(i)); // only check if I'm correct
                    Integer tempValue = numbers.get(i);
                    even.add(tempValue);
                }
            }
        } else {
            System.out.println("There are no even values in a given array");
        }
        return even;
    }
}
