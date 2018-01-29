package com.kodilla.patterns2.adapter.bookclasifier.librarya;

public class TheBook {
    final private String author;
    final private String title;
    final private int publicationYear;
    final private String signature;

    public TheBook(String author, String title, int publicationYear, String signature) {
        this.author = author;
        this.title = title;
        this.publicationYear = publicationYear;
        this.signature = signature;
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

    public String getSignature() {
        return signature;
    }
}
