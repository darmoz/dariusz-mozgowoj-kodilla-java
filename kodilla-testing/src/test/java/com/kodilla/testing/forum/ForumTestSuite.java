package com.kodilla.testing.forum;

import com.kodilla.testing.forum.ForumComment;
import com.kodilla.testing.forum.ForumPost;
import com.kodilla.testing.forum.ForumUser;
import org.junit.*;

public class ForumTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }
    @Test
    public void testAddPost(){
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        //When
        forumUser.addPost("mrsmith","This is my first post" );
        //Then
        Assert.assertEquals(1, forumUser.getPostsQuantity());
    }
    @Test
    public void testAddComment(){
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("This is my first post", "mrsmith");
        //When
        forumUser.addComment(thePost,"mrsmith","This is my first comment");
        //Then
        Assert.assertEquals(1, forumUser.getCommentsQuantity());
    }
    @Test
    public void testGetPost(){
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("This is my first post", "mrsmith");

        forumUser.addPost(thePost.getAuthor(), thePost.getPostBody() );
        //When
        ForumPost retrievedPost;
        retrievedPost = forumUser.getPost(0);
        //Then
        Assert.assertEquals(thePost, retrievedPost);

    }
    @Test
    public void testGetComment() {
        //Given
        ForumUser forumUser = new ForumUser("mrsmith", "John Smith");
        ForumPost thePost = new ForumPost("This is my post", "mrsmith");
        ForumComment theComment = new ForumComment(thePost, "This is my comment", "mrsmith");

        forumUser.addComment(thePost,theComment.getAuthor(),theComment.getCommentBody());
        //When
        ForumComment retrievedComment;
        retrievedComment = forumUser.getComment(0);
        //Then
        Assert.assertEquals(theComment, retrievedComment);

    }
}
