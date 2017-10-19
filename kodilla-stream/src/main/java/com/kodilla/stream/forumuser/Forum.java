package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> listOfUsers = new ArrayList<>();

    public Forum() {
        listOfUsers.add(new ForumUser(12,"Adam",'M', LocalDate.of(1982,4,1), 7));
        listOfUsers.add(new ForumUser(19,"Piotr",'M', LocalDate.of(1983,7,12), 18));
        listOfUsers.add(new ForumUser(2,"Zbigniew",'M', LocalDate.of(1991,1,24), 2));
        listOfUsers.add(new ForumUser(17,"Aneta",'F', LocalDate.of(1992,12,12), 100));
        listOfUsers.add(new ForumUser(10,"Jolanta",'F', LocalDate.of(1979,2,14), 0));
        listOfUsers.add(new ForumUser(1,"Zuzanna",'F', LocalDate.of(1999,9,2), 2));
    }
    public List<ForumUser> getUserList() {
        return new ArrayList<>(listOfUsers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Forum forum = (Forum) o;

        return listOfUsers.equals(forum.listOfUsers);
    }

    @Override
    public int hashCode() {
        return listOfUsers.hashCode();
    }
}

