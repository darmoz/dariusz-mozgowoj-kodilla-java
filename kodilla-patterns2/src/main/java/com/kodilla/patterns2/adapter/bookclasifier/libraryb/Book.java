package com.kodilla.patterns2.adapter.bookclasifier.libraryb;

public class Book {
    final private String author;
    final private String title;
    final private int publicationYear;

    public Book(String author, String title, int publicationYear) {
        this.author = author;
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}
