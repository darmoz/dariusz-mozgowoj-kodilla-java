package com.kodilla.patterns2.adapter.bookclasifier;

import com.kodilla.patterns2.adapter.bookclasifier.librarya.TheBook;
import com.kodilla.patterns2.adapter.bookclasifier.librarya.Classifier;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.Book;
import com.kodilla.patterns2.adapter.bookclasifier.libraryb.Signature;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MedianAdapter extends MedianAdaptee implements Classifier {
    @Override
    public int publicationYearMedian(Set<TheBook> theBookSet) {
        Map<Signature, Book> mapOfBooks = new HashMap<>();
        for(TheBook books: theBookSet) {
            mapOfBooks.put(new Signature(books.getSignature()),
                    new Book(books.getAuthor(), books.getTitle(), books.getPublicationYear()));
        }
        return medianPublicationYear(mapOfBooks);
    }
}
