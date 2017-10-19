package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class MainForum {

    public static void main (String[] args) {

        Forum forum = new Forum();
        LocalDate yearLimit = LocalDate.of(1997,10,19);

        Map<Integer, ForumUser> par = forum.getUserList().stream()
                //.filter(man -> man.getGender() == 'M')
                .filter(older -> older.getBirthDay().isBefore(yearLimit))
                .filter(havePosts -> havePosts.getQuantityOfPosts()>0)
                .collect(Collectors.toMap(ForumUser::getId, havePost -> havePost));

        System.out.println("# entry :" + par.size());
        String display = par.entrySet().stream()
                .map(entry -> entry.getValue())
                .map(ForumUser::toString)
                .collect(Collectors.joining(",\n","",""));

        System.out.println(display);
    }
}
