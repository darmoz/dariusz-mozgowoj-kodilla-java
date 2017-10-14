package com.kodilla.testing.forum;

import java.util.*;

public class ForumUser {
    private String name;
    private String realName;
    private ArrayList<ForumPost> posts = new ArrayList<ForumPost>();
    private LinkedList<ForumComment> comments = new LinkedList<ForumComment>();

    public ForumUser(String name, String realName) {
        this.name = name;
        this.realName = realName;
    }

    public void addPost(String author, String postBody) {
        ForumPost thePost = new ForumPost(postBody, author);
        posts.add(thePost);
    }

    public void addComment(ForumPost forumPost, String author, String commentBody) {
        ForumComment theComment = new ForumComment(forumPost, commentBody, author);
        comments.add(theComment);
    }

    public int getPostsQuantity(){
        return posts.size();
    }

    public int getCommentsQuantity(){
        return comments.size();
    }

    public ForumPost getPost(int postNumber){
        ForumPost thePost = null;
        if (postNumber >= 0 && postNumber < posts.size()) {
            thePost = posts.get(postNumber);
        }
        return thePost;
    }

    public ForumComment getComment(int commentNumber){
        ForumComment theComments = null;
        if (commentNumber >= 0 && commentNumber < comments.size()) {
            theComments = comments.get(commentNumber);
        }
        return theComments;
    }

    public boolean removePost(ForumPost thePost){

        return true;
    }

    public boolean removeComment(ForumComment theComment){

        return true;
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }
}
