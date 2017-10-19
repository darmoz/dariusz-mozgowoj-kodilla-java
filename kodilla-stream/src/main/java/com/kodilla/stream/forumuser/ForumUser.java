package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {

    private final int  id;
    private final String userName;
    private final char gender;
    private final LocalDate birthDay;
    private final int quantityOfPosts;

    public ForumUser(int id, String userName, char gender, LocalDate birthDay, int quantityOfPosts) {
        this.id = id;
        this.userName = userName;
        this.gender = gender;
        this.birthDay = birthDay;
        this.quantityOfPosts = quantityOfPosts;
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public char getGender() {
        return gender;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public int getQuantityOfPosts() {
        return quantityOfPosts;
    }
}
