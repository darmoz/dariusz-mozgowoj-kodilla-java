package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.forum.statistics.Statistics;
import java.util.*;

public class Calculate {
    Statistics statistics;

    public Calculate(Statistics statistics) {
        this.statistics=statistics;
    }
    double currentPostNo;
    double currentCommentsNo;
    double avgUserPostNo;
    double avgUserCommentsNo;
    double avgUserPostComments;
    boolean divZeroUsers;
    boolean divZeroPosts;

    Statistics calculateAdvStatistics(Statistics statistics){
        List<String> resultList = new ArrayList<String>();
        double currentPostNo = statistics.postsCount();
        this.currentPostNo = currentPostNo;
        double currentCommentsNo = statistics.commentsCount();
        this.currentCommentsNo = currentCommentsNo;
        if(statistics.usersNames().size()!=0) {
            for (int i = 0; i < statistics.usersNames().size(); i++) {
                resultList.add(statistics.usersNames().get(i));
            }
            double avgUserPostNo = currentPostNo / statistics.usersNames().size();
            this.avgUserPostNo = avgUserPostNo;
            double avgUserCommentsNo = currentCommentsNo / statistics.usersNames().size();
            this.avgUserCommentsNo = avgUserCommentsNo;
        } else {
            boolean divZeroUsers = true;
            this.divZeroUsers=divZeroUsers;
        }
        if(statistics.postsCount()!= 0) {
            double avgUserPostComments = currentCommentsNo / currentPostNo;
            this.avgUserPostComments = avgUserPostComments;
        } else {
            boolean divZeroPosts = true;
            this.divZeroPosts = divZeroPosts;
        }
        return statistics;
    }
}
