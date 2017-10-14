package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.forum.statistics.Calculate;
import com.kodilla.testing.forum.statistics.Statistics;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

public class ForumStatisticsTestSuite {

    @Test
    public void testCommentsMoreThanPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userList = new ArrayList<String>();
        userList.add("Jan");
        userList.add("Piotr");
        when(statisticsMock.usersNames()).thenReturn(userList);
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(100);

        Calculate calculate = new Calculate(statisticsMock);
        //When
        Statistics values = calculate.calculateAdvStatistics(statisticsMock);
        double quantityOfUsers = values.usersNames().size();
        double quantityOfPosts = values.postsCount();
        double quantityOfComments = values.commentsCount();
        double avgPostPerUser = calculate.avgUserPostNo;
        double avgCommentPerUser = calculate.avgUserCommentsNo;
        double avgCommentPerPost = calculate.avgUserPostComments;

        //Then
        Assert.assertEquals(2, quantityOfUsers, 0);
        Assert.assertEquals(10, quantityOfPosts, 0);
        Assert.assertEquals(100, quantityOfComments, 0);
        Assert.assertEquals(5.0, avgPostPerUser, 0);
        Assert.assertEquals(50.0, avgCommentPerUser, 0);
        Assert.assertEquals(10.0, avgCommentPerPost, 0);

    }

    @Test
    public void testLackOfUsers() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userList = new ArrayList<String>();
        when(statisticsMock.usersNames()).thenReturn(userList);

        Calculate calculate = new Calculate(statisticsMock);
        //When
        Statistics values = calculate.calculateAdvStatistics(statisticsMock);
        double quantityOfUsers = values.usersNames().size();
        boolean userZero = calculate.divZeroUsers;

        //Then
        Assert.assertTrue(userZero);
        Assert.assertEquals(0, quantityOfUsers, 0);

    }

    @Test
    public void testHundredUsers() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userList = new ArrayList<String>();
        String entryA = "";
        for (int i = 0; i < 100; i++) {
            entryA += "a";
            userList.add(entryA);
        }
        when(statisticsMock.usersNames()).thenReturn(userList);
        when(statisticsMock.postsCount()).thenReturn(10);
        when(statisticsMock.commentsCount()).thenReturn(100);

        Calculate calculate = new Calculate(statisticsMock);
        //When
        Statistics values = calculate.calculateAdvStatistics(statisticsMock);
        double avgPostPerUser = calculate.avgUserPostNo;
        double avgCommentPerUser = calculate.avgUserCommentsNo;
        double avgCommentPerPost = calculate.avgUserPostComments;

        //Then
        Assert.assertEquals(0.1, avgPostPerUser, 0);
        Assert.assertEquals(1, avgCommentPerUser, 0);
        Assert.assertEquals(10.0, avgCommentPerPost,0);
    }
    @Test
    public void testPostsMoreThanComments() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userList = new ArrayList<String>();
        userList.add("Jan");
        userList.add("Piotr");
        when(statisticsMock.usersNames()).thenReturn(userList);
        when(statisticsMock.postsCount()).thenReturn(100);
        when(statisticsMock.commentsCount()).thenReturn(10);

        Calculate calculate = new Calculate(statisticsMock);
        //When
        Statistics values = calculate.calculateAdvStatistics(statisticsMock);
        double avgPostPerUser = calculate.avgUserPostNo;
        double avgCommentPerUser = calculate.avgUserCommentsNo;
        double avgCommentPerPost = calculate.avgUserPostComments;

        //Then
        Assert.assertEquals(50.0, avgPostPerUser, 0);
        Assert.assertEquals(5.0, avgCommentPerUser, 0);
        Assert.assertEquals(0.1, avgCommentPerPost, 0);
    }
    @Test
    public void testLackOfPosts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userList = new ArrayList<String>();
        userList.add("Jan");
        userList.add("Piotr");
        when(statisticsMock.usersNames()).thenReturn(userList);
        when(statisticsMock.postsCount()).thenReturn(0);
        when(statisticsMock.commentsCount()).thenReturn(10);

        Calculate calculate = new Calculate(statisticsMock);
        //When
        Statistics values = calculate.calculateAdvStatistics(statisticsMock);
        double avgPostPerUser = calculate.avgUserPostNo;
        double avgCommentPerUser = calculate.avgUserCommentsNo;
        boolean zeroPosts = calculate.divZeroPosts;

        //Then
        Assert.assertEquals(0, avgPostPerUser, 0);
        Assert.assertEquals(5.0, avgCommentPerUser, 0);
        Assert.assertTrue(zeroPosts);
    }
    @Test
    public void test1000Posts() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        List<String> userList = new ArrayList<String>();
        userList.add("Jan");
        userList.add("Piotr");
        when(statisticsMock.usersNames()).thenReturn(userList);
        when(statisticsMock.postsCount()).thenReturn(1000);
        when(statisticsMock.commentsCount()).thenReturn(100);

        Calculate calculate = new Calculate(statisticsMock);
        //When
        Statistics values = calculate.calculateAdvStatistics(statisticsMock);
        double avgPostPerUser = calculate.avgUserPostNo;
        double avgCommentPerUser = calculate.avgUserCommentsNo;
        double avgCommentPerPost = calculate.avgUserPostComments;

        //Then
        Assert.assertEquals(500.0, avgPostPerUser, 0);
        Assert.assertEquals(50.0, avgCommentPerUser, 0);
        Assert.assertEquals(0.1, avgCommentPerPost, 0);
    }
}
