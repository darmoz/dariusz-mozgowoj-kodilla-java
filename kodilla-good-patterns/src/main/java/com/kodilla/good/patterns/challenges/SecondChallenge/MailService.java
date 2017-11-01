package com.kodilla.good.patterns.challenges.SecondChallenge;

public class MailService implements InformationService{

    public void inform(User user) {
        System.out.println("E-mail has been sent to : " + user.getFirstName() + " " + user.getLastName());
    }
}
