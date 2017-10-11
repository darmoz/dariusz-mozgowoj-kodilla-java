package com.kodilla.testing;

import com.kodilla.testing.user.SimpleUser;
import com.kodilla.testing.calculator.Calculator;

public class TestingMain2 {
    public static void main(String[] args){
        SimpleUser simpleUser = new  SimpleUser("forumUser");

        String result = simpleUser.getUsername();

        if(result.equals("forumUser")){
            System.out.println("Test OK");
        } else {
            System.out.println("test failed");
        }
        Calculator testAdd = new Calculator();

            int addResult = testAdd.add(5,4);

            if(addResult == 9){
                System.out.println("Test dodawania OK");
            } else {
                System.out.println("Error!");
            }
        Calculator testSubtract = new Calculator();

            int subtractResult = testSubtract.subtract(6, 3);

        if(subtractResult == 3){
            System.out.println("Test odejmowania OK");
        } else {
            System.out.println("Error!");
        }

     }
}
