package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {

    private final int  id;
    private final String userName;
    private final char gender;
    private final LocalDate birthDay;
    private final int quantityOfPosts;

    public ForumUser(final int id, final String userName, final char gender, final LocalDate birthDay, final int quantityOfPosts) {
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

    @Override
    public String toString() {
        return "ForumUser{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", gender=" + gender +
                ", birthDay=" + birthDay +
                ", quantityOfPosts=" + quantityOfPosts +
                '}';
    }
}
